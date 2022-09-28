package com.example.domain.usecases

import com.example.domain.model.ResultDomainModel
import com.example.domain.repositories.RemoteRepo
import kotlinx.coroutines.flow.Flow

class GetGenreMoviesUseCase(private val repo: RemoteRepo) : CommonsUseCaseParam<Int, ResultDomainModel> {
    override suspend fun execute(param: Int): List<ResultDomainModel> {
        return repo.getGenreMoviesDetail(param)
    }
}