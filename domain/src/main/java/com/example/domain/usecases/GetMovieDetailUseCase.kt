package com.example.domain.usecases

import com.example.domain.model.MovieDetailDomainModel
import com.example.domain.repositories.AppRepo

class GetMovieDetailUseCase(private val repo: AppRepo) :
    CommonUseCaseParam<Int ,MovieDetailDomainModel> {
    override suspend fun execute(param: Int): MovieDetailDomainModel? {
        return repo.getMovieDetail(param)
    }
}