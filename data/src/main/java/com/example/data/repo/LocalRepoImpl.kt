package com.example.data.repo

import com.example.data.db.AppDatabase
import com.example.data.db.model.GenreEntity
import com.example.data.db.model.GenreMovieEntity
import com.example.data.db.model.MovieDetailEntity
import com.example.data.db.model.ResultEntity
import com.example.data.mappers.*
import com.example.domain.model.GenreDomainModel
import com.example.domain.model.MovieDetailDomainModel
import com.example.domain.model.ResultDomainModel

class LocalRepoImpl(private val dbService: AppDatabase) : LocalRepo {

    override suspend fun getGenresDetail(): List<GenreDomainModel> {
        return dbService.genreDao().getAll().map {
            it.toListGenreDomainModel()
        }
    }

    override suspend fun getMovieDetail(movieId: Int): MovieDetailDomainModel {
        return dbService.movieDetailDao().loadAllByIds(movieId).toMovieDetailDomainModel()
    }

    override suspend fun insertMovieDetail(data: MovieDetailEntity) {
        dbService.movieDetailDao().insert(data)
    }


    override suspend fun getUpComingMoviesDetail(): List<ResultDomainModel> {
        return dbService.upcomingMoviesDao().getAll().map {
            it.toResultDomainModel()
        }
    }

    override suspend fun insertAllUpComingMovie(list: List<ResultEntity>){
        dbService.upcomingMoviesDao().insertAll(list)
    }

    override suspend fun getPopularMoviesDetail(): List<ResultDomainModel> {
        return dbService.popularMoviesDao().getAll().map {
            it.toResultDomainModel()
        }
    }

    override suspend fun insertAllPopularMovie(list: List<ResultEntity>){
        dbService.popularMoviesDao().insertAll(list)
    }

    override suspend fun getGenreMoviesDetail(genreId: Int): List<ResultDomainModel> {
        return dbService.genreMoviesDao().getAll().map {
            it.toResultDomainModel()
        }
    }

    override suspend fun insertAllGenreMovies(list: List<GenreMovieEntity>){
        dbService.genreMoviesDao().insertAll(list)
    }

    override suspend fun getTopRatedMoviesDetail(): List<ResultDomainModel> {
        return dbService.topRatedMoviesDao().getAll().map {
            it.toResultDomainModel()
        }
    }

    override suspend fun insertAllTopRatedMovies(list: List<ResultEntity>){
        dbService.topRatedMoviesDao().insertAll(list)
    }

    override suspend fun insertAllGenre(list: List<GenreEntity>) {
        return dbService.genreDao().insertAll(list)
    }


}