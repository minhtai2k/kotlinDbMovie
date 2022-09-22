package com.example.data.repo

import com.example.data.apiservice.API_KEY
import com.example.data.apiservice.ApiService
import com.example.data.mappers.toGenreDetailModel
import com.example.data.mappers.toMovieDetailsModel
import com.example.domain.models.*
import com.example.domain.repositories.RemoteRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(
    private val apiService: ApiService) : RemoteRepo {
    override suspend fun getGenreDetail(): Flow<GenreDetailsModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getGenresDetail(): Flow<List<GenreDetailsModel>> {
        return apiService.getGenresDetails(API_KEY).map {
            it.map { genreDataModel ->  genreDataModel.toGenreDetailModel()}
        }
    }

    override suspend fun getMovieDetail(movieId: Int): Flow<MovieDetailsModel> {
        return apiService.getMovieDetail(movieId = movieId ,API_KEY).map {
            it.toMovieDetailsModel()
        }
    }

    override suspend fun getResultDetail(): Flow<ResultDetailsModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getResultsDetail(): Flow<ResultsDetailsModel> {
        TODO()
    }

}
