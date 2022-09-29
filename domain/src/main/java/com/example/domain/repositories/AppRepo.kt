package com.example.domain.repositories

import com.example.domain.model.*
import kotlinx.coroutines.flow.Flow

interface AppRepo {
    suspend fun getMovieDetail(movieId: Int): MovieDetailDomainModel?
    suspend fun getGenreMoviesDetail(genreId: Int): List<ResultDomainModel>
    suspend fun getUpComingMoviesDetail(): List<ResultDomainModel>
    suspend fun getPopularMoviesDetail(): List<ResultDomainModel>
    suspend fun getGenresDetail(): List<GenreDomainModel>
    suspend fun getTopRatedMoviesDetail(): List<ResultDomainModel>
}
