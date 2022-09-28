package com.example.domain.usecases

import com.example.domain.model.GenreDomainModel
//import com.example.domain.model.GenreListDomainModel
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
//    CommonUseCase<GenresDomainModel> {
//    override suspend fun execute(): GenresDomainModel {
//        return apiRepo.getGenresDetail()
//    }
//}