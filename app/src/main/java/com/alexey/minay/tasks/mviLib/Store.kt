package com.alexey.minay.tasks.mviLib

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class Store<TState : Any, TAction : Any, TResult : Any>(
        private val executor: Executor<TAction, TState, TResult>,
        private val reducer: IReducer<TResult, TState>,
        initialState: TState
) : ViewModel() {

    val state: StateFlow<TState> by lazy(LazyThreadSafetyMode.NONE) { mState.asStateFlow() }

    private val mState = MutableStateFlow(initialState)

    init {
        executor.init(
                reduce = { result ->
                    viewModelScope.launch {
                        reducer.run { mState.value = mState.value.reduce(result) }
                    }
                },
        )
    }

    fun accept(action: TAction) {
        viewModelScope.launch {
            executor.execute(
                    action = action,
                    getState = { mState.value }
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        executor.dispose()
    }

}


