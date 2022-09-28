package com.example.data.repo

import com.example.data.db.model.*
import com.example.data.models.ResultDataModel
import com.example.data.models.ResultsDataModel
import com.example.domain.model.*

interface LocalRepo{
    suspend fun getGenresDetail() : List<GenreDomainModel>
    suspend fun insertAllGenre(list: List<GenreEntity>)

//    suspend fun getGenresListDetail() : GenreListDomainModel
//    suspend fun insertAllGenreList(list: List<GenreEntity>)

    suspend fun getMovieDetail(movieId: Int): MovieDetailDomainModel
    suspend fun insertMovieDetail(data: MovieDetailEntity)

    suspend fun getPopularMoviesDetail() : List<ResultDomainModel>
    suspend fun insertAllPopularMovie(list: List<PopularMovieEntity>)

    suspend fun getGenreMoviesDetail(genreId: Int) : List<ResultDomainModel>
    suspend fun insertAllGenreMovies(list: List<GenreMovieEntity>)

//    Use ResultsDataModel instead of ResultsDomainModel
    suspend fun getUpComingMoviesDetail() : List<ResultDomainModel>
    suspend fun insertAllUpComingMovie(list: List<UpcomingMovieEntity>)

//    Use ResultsDataModels instead of ResultsDomainModel and use List instead of Results
    suspend fun getTopRatedMoviesDetail() : List<ResultDomainModel>
    suspend fun insertAllTopRatedMovies(list: List<TopRatedMovieEntity>)

}