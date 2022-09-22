package com.example.domain.usecases

import com.example.domain.models.MovieDetailsModel
import com.example.domain.repositories.RemoteRepo
import kotlinx.coroutines.flow.Flow

class GetMovieDetailUseCase(private val apiRepo: RemoteRepo, private val movieId: Int) :
    CommonUseCase<MovieDetailsModel> {
    override suspend fun execute(): Flow<MovieDetailsModel> {
        return apiRepo.getMovieDetail(movieId)
    }
}