package com.example.domain.usecases

interface CommonUseCase<R> {
    suspend fun execute() : R
}

interface CommonsUseCase<R> {
    suspend fun execute() : List<R>
}
