package com.example.domain.utils

sealed class State<out T> {
    object LoadingState : State<Nothing>()
    data class ErrorState(var exception: Throwable) : State<Nothing>()
    data class DataState<T>(var data: T) : State<T>()
}

//sealed class Resource<T>(val data: T? =null, val message: String? = null) {
//    class Success<T>(data: T?) : Resource<T>(data)
//    class Error<T>(data: T?, message: String?) : Resource<T>(data, message)
//    class Loading<T>(data: T? = null) : Resource<T>(data)
//}

//enum class Status {
//    SUCCESS,
//    ERROR,
//    LOADING
//}
//
//companion object {
//    fun <T> success(data: T): Resource<T> {
//        return Resource(Status.SUCCESS, data, null)
//    }
//
//    fun <T> error(message: String, data: T? = null): Resource<T> {
//        return Resource(Status.ERROR, data, message)
//    }
//
//    fun <T> loading(data: T? = null): Resource<T> {
//        return Resource(Status.LOADING, data, null)
//    }
//}