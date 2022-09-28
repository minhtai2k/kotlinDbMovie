package com.example.domain.usecases

interface CommonUseCase<R> {
    suspend fun execute() : R
}

interface CommonsUseCase<R> {
    suspend fun execute() : List<R>
}

interface CommonsUseCaseParam<P, R> {
    suspend fun execute(param: P) : List<R>
}

interface CommonUseCaseParam<P, R> {
    suspend fun execute(param: P) : R?
}
