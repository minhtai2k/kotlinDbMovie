package com.example.domain.usecases

import com.example.domain.models.GenreDetailsModel
//import com.example.domain.models.GenresDetailsModel
import com.example.domain.repositories.RemoteRepo
import kotlinx.coroutines.flow.Flow

class GetGenreUseCase(private val apiRepo: RemoteRepo) :
    CommonUseCase<GenreDetailsModel> {
    override suspend fun execute(): Flow<GenreDetailsModel> {
        return apiRepo.getGenreDetail()
    }
}

class GetGenresUseCase(private val apiRepo: RemoteRepo) :
    CommonUseCase<List<GenreDetailsModel>> {
    override suspend fun execute(): Flow<List<GenreDetailsModel>> {
        return apiRepo.getGenresDetail()
    }
}