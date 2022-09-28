package com.example.data.repo

import com.example.data.apiservice.ApiService
import com.example.data.mappers.*
import com.example.data.utils.Constants.API_KEY
import com.example.domain.model.*
import com.example.domain.repositories.AppRepo
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(
    private val apiService: ApiService,
) : RemoteRepo {

//    override suspend fun getMovieDetailLocal(movieId: Int): MovieDetailDomainModel {
//        val dataApi = apiService.getMovieDetail(movieId, API_KEY)
//        return dataApi.toMovieDomainModel()
//    }
//
//    override suspend fun getPopularMoviesLocal(): List<ResultDomainModel> {
//        val dataApi = apiService.getPopularMovieDetails()
//        return dataApi.results.map { it.toResultDomainModel() }
//    }
//
//    override suspend fun getUpComingMoviesLocal(): List<ResultDomainModel> {
//        val dataApi = apiService.getUpcomingMovieLocals()
//        return dataApi.results.map { it.toResultDomainModel() }
//    }
    
//    override suspend fun getGenresLocal(): List<GenreDomainModel> {
//        val dataApi = apiService.getGenresLocals(API_KEY)
//        return dataApi.genres.map { it.toGenreDomainModel() }
//    }

//    override suspend fun getTopRatedMoviesLocal(): List<ResultDomainModel> {
//        val dataApi = apiService.getTopRatedMovieLocals()
//        return dataApi.results.map { it.toResultDomainModel() }
//    }

//    override suspend fun getGenreMoviesLocal(genreId: Int): List<ResultDomainModel> {
//        val dataApi = apiService.getGenreMoviesLocal(API_KEY, genreId)
//        return dataApi.results.map { it.toResultDomainModel() }
//    }

    override suspend fun getGenresRemote(): List<GenreDomainModel> {
        val dataApi = apiService.getGenresDetail(API_KEY)
        return dataApi.genres.map { it.toGenreDomainModel() }
    }

    override suspend fun getMovieDetailRemote(movieId: Int): MovieDetailDomainModel {
        val dataApi = apiService.getMovieDetail(movieId, API_KEY)
        return dataApi.toMovieDomainModel()
    }

    override suspend fun getPopularMoviesRemote(): List<ResultDomainModel> {
        val dataApi = apiService.getPopularMoviesDetail()
        return dataApi.results.map { it.toResultDomainModel() }
    }

    override suspend fun getGenreMoviesRemote(genreId: Int): List<ResultDomainModel> {
        val dataApi = apiService.getGenreMoviesDetail(API_KEY, genreId)
        return dataApi.results.map { it.toResultDomainModel() }
    }

    override suspend fun getUpComingMoviesRemote(): List<ResultDomainModel> {
        val dataApi = apiService.getUpcomingMoviesDetail()
        return dataApi.results.map { it.toResultDomainModel() }
    }

    override suspend fun getTopRatedMoviesRemote(): List<ResultDomainModel> {
        val dataApi = apiService.getTopRatedMoviesDetail()
        return dataApi.results.map { it.toResultDomainModel() }
    }

}

//Use DataModel instead of DomainModel
//override suspend fun getUpComingMoviesLocal(): ResultsDomainModel {
//    val dataApi = apiService.getUpcomingMovieLocals()
//    return dataApi.toResultsDomainModel()
//}

//    Use DataModel instead of DomainModel
//override suspend fun getUpComingMoviesLocal(): ResultsDomainModel {
//    val dataApi = apiService.getUpcomingMovieLocals()
//    return dataApi.toResultsDomainModel()
//}