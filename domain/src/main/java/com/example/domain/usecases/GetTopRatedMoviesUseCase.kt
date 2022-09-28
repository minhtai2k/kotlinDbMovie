package com.example.domain.usecases

import com.example.domain.model.ResultDomainModel
import com.example.domain.repositories.AppRepo

class GetTopRatedMoviesUseCase(private val repo: AppRepo) : CommonsUseCase<ResultDomainModel> {
    override suspend fun execute(): List<ResultDomainModel> {
        return repo.getTopRatedMoviesDetail()
    }
}