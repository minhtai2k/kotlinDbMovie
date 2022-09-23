package com.example.data.repo

import com.example.data.db.AppDatabase
import com.example.domain.model.GenreDomainModel
import com.example.domain.model.MovieDomainModel
import com.example.domain.model.ResultDomainModel
import com.example.domain.model.ResultsDomainModel
import com.example.domain.repositories.RemoteRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalRepoImpl @Inject constructor(
    private val dbService: AppDatabase
) : RemoteRepo {
    override suspend fun getGenresDetail(): Flow<List<GenreDomainModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieDetail(movieId: Int): Flow<MovieDomainModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getUpComingMoviesDetail(): Flow<List<ResultDomainModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPopularMoviesDetail(): Flow<List<ResultDomainModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun getGenreMoviesDetail(genreId: Int): Flow<List<ResultDomainModel>> {
        TODO("Not yet implemented")
    }


    override suspend fun getTopRatedMoviesDetail(): Flow<List<ResultDomainModel>> {
        TODO("Not yet implemented")
    }

}