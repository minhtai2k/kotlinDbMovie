package com.example.domain.repositories
import com.example.domain.models.*
import kotlinx.coroutines.flow.Flow

interface RemoteRepo {
    suspend fun getGenreDetail() : Flow<GenreDetailsModel>
    suspend fun getGenresDetail() : Flow<List<GenreDetailsModel>>

    suspend fun getMovieDetail(movieId: Int): Flow<MovieDetailsModel>

    suspend fun getResultDetail() : Flow<ResultDetailsModel>
    suspend fun getResultsDetail() : Flow<ResultsDetailsModel>
}