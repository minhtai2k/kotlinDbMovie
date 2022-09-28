package com.example.data.repo

import com.example.data.db.AppDatabase
import com.example.data.db.model.*
import com.example.data.mappers.*
import com.example.data.models.ResultDataModel
import com.example.data.models.ResultsDataModel
import com.example.domain.model.*
import javax.inject.Inject

class LocalRepoImpl @Inject constructor(private val dbService: AppDatabase) : LocalRepo {

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

    override suspend fun insertAllUpComingMovie(list: List<UpcomingMovieEntity>) {
        dbService.upcomingMoviesDao().insertAll(list)
    }

    override suspend fun insertAllPopularMovie(list: List<PopularMovieEntity>) {
        return dbService.popularMoviesDao().insertAll(list)
    }

    override suspend fun getGenreMoviesDetail(genreId: Int): List<ResultDomainModel> {
        return dbService.genreMoviesDao().getAll().map {
            it.toResultDomainModel()
        }
    }

    override suspend fun insertAllGenreMovies(list: List<GenreMovieEntity>) {
        dbService.genreMoviesDao().insertAll(list)
    }



    override suspend fun insertAllTopRatedMovies(list: List<TopRatedMovieEntity>) {
        dbService.topRatedMoviesDao().insertAll(list)
    }

    override suspend fun insertAllGenre(list: List<GenreEntity>) {
        return dbService.genreDao().insertAll(list)
    }

//    After Fix
    suspend fun getGenresListDetail(): GenreListDomainModel {
        return GenreListDomainModel(
            dbService.genreDao().getAll().map { it.toListGenreDomainModel() })
    }

    override suspend fun getPopularMoviesDetail(): ResultsDomainModel {
        return ResultsDomainModel(
            dbService.popularMoviesDao().getAll().map {
                it.toResultDomainModel()
            }
        )
    }

    // Use ResultsDataModel
    override suspend fun getUpComingMoviesDetail(): ResultsDomainModel {
        return ResultsDomainModel(
            dbService.upcomingMoviesDao().getAll().map {
                it.toResultDomainModel()
            }
        )
    }

    //Use ResultsDataModel and List instead of Results
    override suspend fun getTopRatedMoviesDetail(): List<ResultDataModel> {
        return dbService.topRatedMoviesDao().getAll().map {
            it.toResultDataModel()
        }
    }

}