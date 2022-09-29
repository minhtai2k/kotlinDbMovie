package com.example.domain.usecases

import com.example.domain.model.GenreDomainModel
import com.example.domain.repositories.AppRepo

class GetGenresUseCase(private val apiRepo: AppRepo) :
    CommonUseCase<List<GenreDomainModel>> {
    override suspend fun execute(): List<GenreDomainModel> {
        return apiRepo.getGenresDetail()
    }
}