package com.example.domain.usecases

import com.example.domain.model.ResultDomainModel
import com.example.domain.repositories.RemoteRepo
import kotlinx.coroutines.flow.Flow

class GetTopRatedMoviesUseCase(private val repo: RemoteRepo) : CommonsUseCase<ResultDomainModel> {
    override suspend fun execute(): List<ResultDomainModel> {
        return repo.getTopRatedMoviesDetail()
    }
}