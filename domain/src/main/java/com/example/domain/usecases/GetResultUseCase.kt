package com.example.domain.usecases

import com.example.domain.models.ResultDetailsModel
import com.example.domain.models.ResultsDetailsModel
//import com.example.domain.models.ResultsDetailsModel
import com.example.domain.repositories.RemoteRepo
import kotlinx.coroutines.flow.Flow

class GetResultUseCase(private val apiRepo: RemoteRepo) :
    CommonUseCase<ResultDetailsModel> {
    override suspend fun execute(): Flow<ResultDetailsModel> {
        return apiRepo.getResultDetail()
    }
}

class GetResultsUseCase(private val apiRepo: RemoteRepo) :
    CommonUseCase<ResultsDetailsModel> {
    override suspend fun execute(): Flow<ResultsDetailsModel> {
        return apiRepo.getResultsDetail()
    }
}