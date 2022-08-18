package com.alexey.minay.tasks.mvi

abstract class Executor<TAction : Any, TState : Any, TResult : Any> {

    protected val reduce get() = mReduce

    private lateinit var mReduce: (TResult) -> Unit

    fun init(
        reduce: (TResult) -> Unit,
    ) {
        this.mReduce = reduce
    }

    fun dispose() {
        mReduce = {}
    }

    abstract suspend fun execute(action: TAction, getState: () -> TState)

}

