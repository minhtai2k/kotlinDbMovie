package com.example.data.repo

import com.example.data.apiservice.ApiService
import com.example.data.db.AppDatabase
import com.example.data.mappers.*
import com.example.data.utils.Constants.API_KEY
import com.example.domain.model.*
import com.example.domain.repositories.RemoteRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(
    private val apiService: ApiService,
//    private val dbService: AppDatabase
) : RemoteRepo {

    override suspend fun getGenresDetail(): List<GenreDomainModel> {
        val dataApi = apiService.getGenresDetails(API_KEY)
        return dataApi.map { it.toGenreDomainModel() }
    }

    override suspend fun getMovieDetail(movieId: Int): MovieDetailDomainModel {
        val dataApi = apiService.getMovieDetail(movieId, API_KEY)
//        dbService.movieDetailDao().insert(dataApi.toMovieDetailEntity())
        return dataApi.toMovieDomainModel()
    }



//    override suspend fun getPopularMoviesDetail(): List<ResultDomainModel> {
//        val dataApi = apiService.getPopularMovieDetails()
////        dbService.popularMoviesDao().insertAll(dataApi.map { it.toResultEntity() })
//        return dataApi.map { it.toResultDomainModel() }
//    }

//    After Fix
    override suspend fun getPopularMoviesDetail(): ResultsDomainModel {
        val dataApi = apiService.getPopularMovieDetails()
        return dataApi.toResultsDomainModel()
    }

    override suspend fun getGenresListDetail(): GenreListDomainModel {
        val dataApi = apiService.getGenresListDetails(API_KEY)
        return dataApi.toGenresDomainModel()
    }

//    Use DataModel instead of DomainModel
    override suspend fun getUpComingMoviesDetail(): ResultsDomainModel {
        val dataApi = apiService.getUpcomingMovieDetails()
        return dataApi.toResultsDomainModel()
    }

//    Use List<Result> instead of Results
    override suspend fun getTopRatedMoviesDetail(): List<ResultDomainModel> {
        val dataApi = apiService.getTopRatedMovieDetails()
        return dataApi.results.map { it.toResultDomainModel() }
    }

    override suspend fun getGenreMoviesDetail(genreId: Int): List<ResultDomainModel> {
        val dataApi = apiService.getGenreMoviesDetail(API_KEY, genreId)
        return dataApi.results.map { it.toResultDomainModel() }
    }

}
