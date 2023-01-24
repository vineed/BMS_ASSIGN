package com.bookmyshow.feature_one.repository

sealed class Result<T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Failure(val message: String): Result<Nothing>()
    data class Exception(val throwable: Throwable): Result<Nothing>()
}