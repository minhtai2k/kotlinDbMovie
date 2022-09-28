package com.example.domain.usecases

import com.example.domain.model.GenreListDomainModel
//import com.example.domain.model.GenresDomainModel
import com.example.domain.repositories.RemoteRepo

class GetGenresUseCase (private val apiRepo: RemoteRepo) :
    CommonUseCase<GenreListDomainModel> {
    override suspend fun execute(): GenreListDomainModel {
        return apiRepo.getGenresListDetail()
    }
}