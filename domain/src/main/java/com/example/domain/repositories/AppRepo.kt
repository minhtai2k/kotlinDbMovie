package com.example.domain.repositories

import com.example.domain.model.*
import kotlinx.coroutines.flow.Flow

interface AppRepo {
    //    Use List instead of Results
    suspend fun getMovieDetail(movieId: Int): MovieDetailDomainModel

    suspend fun getGenreMoviesDetail(genreId: Int): List<ResultDomainModel>

    suspend fun getUpComingMoviesDetail(): List<ResultDomainModel>
    suspend fun getPopularMoviesDetail(): List<ResultDomainModel>
    suspend fun getGenresDetail(): List<GenreDomainModel>
    suspend fun getTopRatedMoviesDetail(): List<ResultDomainModel>

}

//    Use Results instead of List<>
//  suspend fun getUpComingMoviesDetail() : ResultsDomainModel
//  suspend fun getPopularMoviesDetail() : ResultsDomainModel

//    suspend fun getResultDetail() : Flow<ResultDomainModel>
//    suspend fun getResultsDetail() : Flow<ResultsDomainModel>
//    suspend fun getGenresDetail() : Flow<List<GenreDomainModel>>
//    suspend fun getPopularMoviesDetail() : List<ResultDomainModel>
//    suspend fun getUpComingMoviesDetail() : List<ResultDomainModel>
