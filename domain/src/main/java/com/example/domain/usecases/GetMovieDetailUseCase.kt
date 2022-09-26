package com.example.domain.usecases

import com.example.domain.model.MovieDetailDomainModel
import com.example.domain.repositories.RemoteRepo
import kotlinx.coroutines.flow.Flow

class GetMovieDetailUseCase(private val repo: RemoteRepo, private val movieId: Int) :
    CommonUseCase<MovieDetailDomainModel> {
    override suspend fun execute(): MovieDetailDomainModel {
        return repo.getMovieDetail(movieId)
    }
}