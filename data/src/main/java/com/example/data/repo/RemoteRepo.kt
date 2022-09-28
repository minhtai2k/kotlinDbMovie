package com.example.data.repo

import com.example.domain.model.GenreDomainModel
import com.example.domain.model.MovieDetailDomainModel
import com.example.domain.model.ResultDomainModel

interface RemoteRepo {
    suspend fun getGenresRemote() : List<GenreDomainModel>
    suspend fun getMovieDetailRemote(movieId: Int): MovieDetailDomainModel
    suspend fun getPopularMoviesRemote() : List<ResultDomainModel>
    suspend fun getGenreMoviesRemote(genreId: Int) : List<ResultDomainModel>
    suspend fun getUpComingMoviesRemote() : List<ResultDomainModel>
    suspend fun getTopRatedMoviesRemote() : List<ResultDomainModel>

}