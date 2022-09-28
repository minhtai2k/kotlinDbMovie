package com.example.data.repo

import com.example.data.db.AppDatabase
import com.example.data.db.model.*
import com.example.data.mappers.*
import com.example.data.models.ResultDataModel
import com.example.data.models.ResultsDataModel
import com.example.domain.model.*
import javax.inject.Inject

class LocalRepoImpl @Inject constructor(
    private val dbService: AppDatabase
) : LocalRepo {

    override suspend fun getGenresLocal(): List<GenreDomainModel> {
        return dbService.genreDao().getAll().map {
            it.toListGenreDomainModel()
        }
    }

    override suspend fun getMovieDetailLocal(movieId: Int): MovieDetailDomainModel? {
        return dbService.movieDetailDao().loadAllByIds(movieId).toMovieDetailDomainModel()
    }

    override suspend fun getGenreMoviesLocal(genreId: Int): List<ResultDomainModel> {
        return dbService.genreMoviesDao().getAll().map {
            it.toResultDomainModel()
        }
    }

    override suspend fun getPopularMoviesLocal(): List<ResultDomainModel> {
        return dbService.popularMoviesDao().getAll().map {
            it.toResultDomainModel()
        }
    }

    override suspend fun getUpComingMoviesLocal(): List<ResultDomainModel> {
        return dbService.upcomingMoviesDao().getAll().map {
            it.toResultDomainModel()
        }
    }

    override suspend fun getTopRatedMoviesLocal(): List<ResultDomainModel> {
        return dbService.topRatedMoviesDao().getAll().map {
            it.toResultDomainModel()
        }
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

    override suspend fun insertAllGenreMovies(list: List<GenreMovieEntity>) {
        dbService.genreMoviesDao().insertAll(list)
    }


    override suspend fun insertAllTopRatedMovies(list: List<TopRatedMovieEntity>) {
        dbService.topRatedMoviesDao().insertAll(list)
    }

    override suspend fun insertAllGenre(list: List<GenreEntity>) {
        return dbService.genreDao().insertAll(list)
    }

}

//Use Result instead of List<>
//suspend fun getGenresListLocal(): GenreListDomainModel {
//    return GenreListDomainModel(
//        dbService.genreDao().getAll().map { it.toListGenreDomainModel() })
//}

//override suspend fun getPopularMoviesLocal(): ResultsDomainModel {
//    return ResultsDomainModel(
//        dbService.popularMoviesDao().getAll().map {
//            it.toResultDomainModel()
//        }
//    )
//}