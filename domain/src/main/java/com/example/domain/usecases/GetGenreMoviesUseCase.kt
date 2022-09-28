package com.example.domain.usecases

import com.example.domain.model.ResultDomainModel
import com.example.domain.repositories.AppRepo

class GetGenreMoviesUseCase(private val repo: AppRepo) : CommonsUseCaseParam<Int, ResultDomainModel> {
    override suspend fun execute(param: Int): List<ResultDomainModel> {
        return repo.getGenreMoviesDetail(param)
    }
}