package com.alexey.minay.tasks.mviLib

fun interface IReducer<TResult : Any, TState : Any> {
    fun TState.reduce(result: TResult): TState
}

