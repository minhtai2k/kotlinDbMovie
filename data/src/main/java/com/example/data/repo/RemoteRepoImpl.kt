package com.example.data.repo

import com.example.data.apiservice.ApiService
import com.example.data.db.AppDatabase
import com.example.data.mappers.*
import com.example.data.utils.Constants.API_KEY
import com.example.domain.model.*
import com.example.domain.repositories.RemoteRepo
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(
    private val apiService: ApiService,
//    private val dbService: AppDatabase
) : RemoteRepo {

    override suspend fun getGenresDetail(): List<GenreDomainModel> {
        val dataApi = apiService.getGenresDetails(API_KEY)
//        dbService.genreDao().insertAll(dataApi.map { it.toGenreEntity() })
        return dataApi.map { it.toGenreDomainModel() }
    }


    override suspend fun getMovieDetail(movieId: Int): MovieDetailDomainModel {
        val dataApi = apiService.getMovieDetail(movieId, API_KEY)
//        dbService.movieDetailDao().insert(dataApi.toMovieDetailEntity())
        return dataApi.toMovieDomainModel()
    }

    override suspend fun getTopRatedMoviesDetail(): List<ResultDomainModel> {
        val dataApi = apiService.getTopRatedMovieDetails()
//        dbService.topRatedMoviesDao().insertAll(dataApi.map { it.toResultEntity() })
        return dataApi.map { it.toResultDomainModel() }
    }

    override suspend fun getUpComingMoviesDetail(): List<ResultDomainModel> {
        val dataApi = apiService.getUpcomingMovieDetails()
//        dbService.upcomingMoviesDao().insertAll(dataApi.map { it.toResultEntity() })
        return dataApi.map { it.toResultDomainModel() }
    }

    override suspend fun getPopularMoviesDetail(): List<ResultDomainModel> {
        val dataApi = apiService.getPopularMovieDetails()
//        dbService.popularMoviesDao().insertAll(dataApi.map { it.toResultEntity() })
        return dataApi.map { it.toResultDomainModel() }
    }

    override suspend fun getGenreMoviesDetail(genreId: Int): List<ResultDomainModel> {
//        return apiService.getGenreMoviesDetail(API_KEY, genreId).map {
//            it.toResultDomainModel()
//        }
        val dataApi = apiService.getGenreMoviesDetail(API_KEY,genreId)
//        dbService.genreMoviesDao().insertAll(dataApi.map { it.toResultEntity() })
        return dataApi.map { it.toResultDomainModel() }
    }


}
