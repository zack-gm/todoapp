package com.example.todoapp.domain

inline class Result<out T>(
    @PublishedApi
    internal val value: Any?
) {
    val isProcess: Boolean get() = value is Process
    val isSuccess: Boolean get() = value !is Throwable && value !is Process
    val isFailure: Boolean get() = value is Throwable

    internal class Progress()

    fun get(): T{
        return value as T;
    }

    fun <R> fold(
        onSuccess: (value: T) -> R,
        onFailure: (throwble: Throwable) -> R
    ): R {
        return when(value){
            is Progress -> Progress() as R
            is Throwable -> onFailure(value)
            else -> onSuccess(value as T)
        }
    }

    companion object{
        fun <T> success(value: T): Result<T> = Result(value)
        fun <T> failure(throwable: Throwable): Result<T> = Result(throwable)
        fun <T> progress(): Result<T> = Result(Progress())
    }
}