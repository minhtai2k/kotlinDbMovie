package com.example.data.repo

import com.example.data.db.model.*
import com.example.data.models.ResultDataModel
import com.example.data.models.ResultsDataModel
import com.example.domain.model.*

interface LocalRepo{
//    suspend fun getGenresDetail() : List<GenreDomainModel>
    suspend fun getGenresLocal() : List<GenreDomainModel>
    suspend fun insertAllGenre(list: List<GenreEntity>)

//    suspend fun getMovieDetail(movieId: Int): MovieDetailDomainModel
    suspend fun getMovieDetailLocal(movieId: Int): MovieDetailDomainModel?
    suspend fun insertMovieDetail(data: MovieDetailEntity)

//    suspend fun getPopularMoviesDetail() : List<ResultDomainModel>
    suspend fun getPopularMoviesLocal() : List<ResultDomainModel>
    suspend fun insertAllPopularMovie(list: List<PopularMovieEntity>)

//    suspend fun getGenreMoviesDetail(genreId: Int) : List<ResultDomainModel>
    suspend fun getGenreMoviesLocal(genreId: Int) : List<ResultDomainModel>
    suspend fun insertAllGenreMovies(list: List<GenreMovieEntity>)

//    suspend fun getUpComingMoviesDetail() : List<ResultDomainModel>
    suspend fun getUpComingMoviesLocal() : List<ResultDomainModel>
    suspend fun insertAllUpComingMovie(list: List<UpcomingMovieEntity>)

//    suspend fun getTopRatedMoviesDetail() : List<ResultDomainModel>
    suspend fun getTopRatedMoviesLocal() : List<ResultDomainModel>
    suspend fun insertAllTopRatedMovies(list: List<TopRatedMovieEntity>)

}