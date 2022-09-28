package com.example.domain.usecases

import com.example.domain.model.ResultDomainModel
import com.example.domain.model.ResultsDomainModel
import com.example.domain.repositories.RemoteRepo
import kotlinx.coroutines.flow.Flow

class GetPopularMoviesUseCase(private val repo: RemoteRepo) : CommonUseCase<ResultsDomainModel> {
    override suspend fun execute(): ResultsDomainModel {
        return repo.getPopularMoviesDetail()
    }
}