package com.alexey.minay.tasks.result

interface Result<out T> {
    class Success<T>(val data: T) : Result<T>
    class Error(val type: ErrorType) : Result<Nothing>

    enum class ErrorType {
        NO_INTERNET,
        SERVER_CONNECTION_ERROR,
        UNKNOWN
    }
}