package com.example.data.repo

import com.example.data.apiservice.ApiService
import com.example.data.mappers.*
import com.example.data.utils.Constants.API_KEY
import com.example.domain.model.*
import com.example.domain.repositories.AppRepo
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(
    private val apiService: ApiService,
//    private val dbService: AppDatabase
) : AppRepo {

    override suspend fun getMovieDetail(movieId: Int): MovieDetailDomainModel {
        val dataApi = apiService.getMovieDetail(movieId, API_KEY)
        return dataApi.toMovieDomainModel()
    }

//    After Fix
    override suspend fun getPopularMoviesDetail(): List<ResultDomainModel> {
        val dataApi = apiService.getPopularMovieDetails()
        return dataApi.results.map { it.toResultDomainModel() }
    }

//    Use DataModel instead of DomainModel
    override suspend fun getUpComingMoviesDetail(): List<ResultDomainModel> {
        val dataApi = apiService.getUpcomingMovieDetails()
        return dataApi.results.map { it.toResultDomainModel() }
    }

//    Use List<Result> instead of Results
    override suspend fun getGenresDetail(): List<GenreDomainModel> {
        val dataApi = apiService.getGenresDetails(API_KEY)
        return dataApi.genres.map { it.toGenreDomainModel() }
    }

    override suspend fun getTopRatedMoviesDetail(): List<ResultDomainModel> {
        val dataApi = apiService.getTopRatedMovieDetails()
        return dataApi.results.map { it.toResultDomainModel() }
    }

    override suspend fun getGenreMoviesDetail(genreId: Int): List<ResultDomainModel> {
        val dataApi = apiService.getGenreMoviesDetail(API_KEY, genreId)
        return dataApi.results.map { it.toResultDomainModel() }
    }

}

//Use DataModel instead of DomainModel
//override suspend fun getUpComingMoviesDetail(): ResultsDomainModel {
//    val dataApi = apiService.getUpcomingMovieDetails()
//    return dataApi.toResultsDomainModel()
//}

//    Use DataModel instead of DomainModel
//override suspend fun getUpComingMoviesDetail(): ResultsDomainModel {
//    val dataApi = apiService.getUpcomingMovieDetails()
//    return dataApi.toResultsDomainModel()
//}