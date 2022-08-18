package com.ispring.islearn.coreui.viewmodel.mvi2

fun interface IReducer<TResult : Any, TState : Any> {
    fun TState.reduce(result: TResult): TState
}

