package com.example.domain.usecases

import com.example.domain.model.GenreDomainModel
//import com.example.domain.models.GenresDomainModel
import com.example.domain.repositories.RemoteRepo
import kotlinx.coroutines.flow.Flow

class GetGenreUseCase (private val repo: RemoteRepo) :
    CommonUseCase<GenreDomainModel> {
    override suspend fun execute(): Flow<GenreDomainModel> {
        return repo.getGenreDetail()
    }
}

//class GetGenresUseCase (private val apiRepo: RemoteRepo) :
//    CommonUseCase<List<GenreDomainModel>> {
//    override suspend fun execute(): Flow<List<GenreDomainModel>> {
//        return apiRepo.getGenresDetail()
//    }
//}