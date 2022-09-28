package com.example.domain.usecases

import com.example.domain.model.ResultDomainModel
import com.example.domain.repositories.AppRepo

class GetUpComingMoviesUseCase(private val repo: AppRepo) : CommonUseCase<List<ResultDomainModel>> {
    override suspend fun execute(): List<ResultDomainModel> {
        return repo.getUpComingMoviesDetail()
    }
}