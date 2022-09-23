package com.example.domain.usecases

import com.example.domain.model.GenreDomainModel
import com.example.domain.model.ResultDomainModel
import com.example.domain.repositories.RemoteRepo
import kotlinx.coroutines.flow.Flow

class GetGenreMoviesUseCase(private val repo: RemoteRepo, private val genreId: Int) : CommonsUseCase<ResultDomainModel> {
    override suspend fun execute(): Flow<List<ResultDomainModel>> {
        return repo.getGenreMoviesDetail(genreId)
    }
}