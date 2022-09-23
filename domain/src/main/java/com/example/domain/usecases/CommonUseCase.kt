package com.example.domain.usecases

import kotlinx.coroutines.flow.Flow

interface CommonUseCase<R> {
    suspend fun execute() : Flow<R>
}

interface CommonsUseCase<R> {
    suspend fun execute() : Flow<List<R>>
}
