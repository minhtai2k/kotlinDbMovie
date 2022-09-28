package com.example.domain.usecases

import com.example.domain.model.MovieDetailDomainModel
import com.example.domain.repositories.RemoteRepo
import kotlinx.coroutines.flow.Flow

class GetMovieDetailUseCase(private val repo: RemoteRepo) :
    CommonUseCaseParam<Int ,MovieDetailDomainModel> {
    //    override suspend fun execute(): MovieDetailDomainModel {
//        return repo.getMovieDetail(movieId)
//    }
    override suspend fun execute(param: Int): MovieDetailDomainModel {
        return repo.getMovieDetail(param)
    }
}