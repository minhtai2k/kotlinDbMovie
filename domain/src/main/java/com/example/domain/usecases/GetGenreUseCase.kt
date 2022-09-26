package com.example.domain.usecases

import com.example.domain.model.GenreDomainModel
//import com.example.domain.models.GenresDomainModel
import com.example.domain.repositories.RemoteRepo
import kotlinx.coroutines.flow.Flow

class GetGenreUseCase (private val repo: RemoteRepo) :
    CommonsUseCase<GenreDomainModel> {
    override suspend fun execute(): List<GenreDomainModel> {
        return repo.getGenresDetail()
    }
}

//class GetGenresUseCase (private val apiRepo: RemoteRepo) :
//    CommonUseCase<List<GenreDomainModel>> {
//    override suspend fun execute(): Flow<List<GenreDomainModel>> {
//        return apiRepo.getGenresDetail()
//    }
//}