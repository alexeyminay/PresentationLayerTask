package com.alexey.minay.tasks.mvi

fun interface IReducer<TResult : Any, TState : Any> {
    fun TState.reduce(result: TResult): TState
}

