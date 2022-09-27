package com.example.data.repo

import com.example.data.db.model.*
import com.example.domain.model.GenreDomainModel
import com.example.domain.model.MovieDetailDomainModel
import com.example.domain.model.ResultDomainModel

interface LocalRepo{
    suspend fun getGenresDetail() : List<GenreDomainModel>
    suspend fun insertAllGenre(list: List<GenreEntity>)

    suspend fun getMovieDetail(movieId: Int): MovieDetailDomainModel
    suspend fun insertMovieDetail(data: MovieDetailEntity)

    suspend fun getUpComingMoviesDetail() : List<ResultDomainModel>
    suspend fun insertAllUpComingMovie(list: List<UpcomingMovieEntity>)

    suspend fun getPopularMoviesDetail() : List<ResultDomainModel>
    suspend fun insertAllPopularMovie(list: List<PopularMovieEntity>)

    suspend fun getGenreMoviesDetail(genreId: Int) : List<ResultDomainModel>
    suspend fun insertAllGenreMovies(list: List<GenreMovieEntity>)

    suspend fun getTopRatedMoviesDetail() : List<ResultDomainModel>
    suspend fun insertAllTopRatedMovies(list: List<TopRatedMovieEntity>)
}