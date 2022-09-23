package com.example.domain.repositories
import com.example.domain.model.*
import kotlinx.coroutines.flow.Flow

interface RemoteRepo {
    suspend fun getGenresDetail() : Flow<List<GenreDomainModel>>
    suspend fun getMovieDetail(movieId: Int): Flow<MovieDomainModel>
    suspend fun getUpComingMoviesDetail() : Flow<List<ResultDomainModel>>
    suspend fun getPopularMoviesDetail() : Flow<List<ResultDomainModel>>
    suspend fun getGenreMoviesDetail(genreId: Int) : Flow<List<ResultDomainModel>>
    suspend fun getTopRatedMoviesDetail() : Flow<List<ResultDomainModel>>
}

//    suspend fun getResultDetail() : Flow<ResultDomainModel>
//    suspend fun getResultsDetail() : Flow<ResultsDomainModel>
//    suspend fun getGenresDetail() : Flow<List<GenreDomainModel>>
