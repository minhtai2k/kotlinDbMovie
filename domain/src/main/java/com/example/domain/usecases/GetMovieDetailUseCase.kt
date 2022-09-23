package com.example.domain.usecases

import com.example.domain.model.MovieDomainModel
import com.example.domain.repositories.RemoteRepo
import kotlinx.coroutines.flow.Flow

class GetMovieDetailUseCase(private val repo: RemoteRepo, private val movieId: Int) :
    CommonUseCase<MovieDomainModel> {
    override suspend fun execute(): Flow<MovieDomainModel> {
        return repo.getMovieDetail(movieId)
    }
}