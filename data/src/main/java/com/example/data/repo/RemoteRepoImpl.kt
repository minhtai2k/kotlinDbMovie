package com.example.data.repo

import com.example.data.apiservice.ApiService
import com.example.data.utils.Constants.API_KEY
import com.example.data.mappers.toGenreDetailModel
import com.example.data.mappers.toMovieDomainModel
import com.example.data.mappers.toResultDomainModel
import com.example.data.mappers.toResultsDomainModel
import com.example.domain.model.*
import com.example.domain.repositories.RemoteRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(
    private val apiService: ApiService) : RemoteRepo {

    override suspend fun getGenresDetail(): Flow<List<GenreDomainModel>> {
        return apiService.getGenresDetails(API_KEY).map {
            it.map { resultDataModel ->  resultDataModel.toGenreDetailModel()}
        }
    }

    override suspend fun getMovieDetail(movieId: Int): Flow<MovieDomainModel> {
        return apiService.getMovieDetail(movieId = movieId ,API_KEY).map {
            it.toMovieDomainModel()
        }
    }

    override suspend fun getTopRatedMoviesDetail(): Flow<List<ResultDomainModel>> {
        return apiService.getTopRatedMovieDetails(API_KEY).map {
            it.map { resultDataModel -> resultDataModel.toResultDomainModel() }
        }
    }

    override suspend fun getUpComingMoviesDetail(): Flow<List<ResultDomainModel>> {
        return apiService.getUpcomingMovieDetails(API_KEY).map {
            it.map { resultDataModel -> resultDataModel.toResultDomainModel() }
        }
    }

    override suspend fun getPopularMoviesDetail(): Flow<List<ResultDomainModel>> {
        return apiService.getPopularMovieDetails(API_KEY).map {
            it.map { resultDataModel -> resultDataModel.toResultDomainModel() }
        }
    }

    override suspend fun getGenreMoviesDetail(genreId: Int): Flow<List<ResultDomainModel>> {
        return apiService.getGenreMoviesDetail(API_KEY, genreId).map {
            it.map { resultDataModel -> resultDataModel.toResultDomainModel() }
        }
    }


}
