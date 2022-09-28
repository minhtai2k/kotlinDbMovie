package com.example.domain.repositories
import com.example.domain.model.*
import kotlinx.coroutines.flow.Flow

interface RemoteRepo {
    suspend fun getGenresDetail() : List<GenreDomainModel>
    suspend fun getMovieDetail(movieId: Int): MovieDetailDomainModel

    suspend fun getUpComingMoviesDetail() : ResultsDomainModel
    suspend fun getPopularMoviesDetail() : ResultsDomainModel
    suspend fun getGenresListDetail() : GenreListDomainModel

//    Use List instead of Results
    suspend fun getTopRatedMoviesDetail() : List<ResultDomainModel>
    suspend fun getGenreMoviesDetail(genreId: Int) : List<ResultDomainModel>
}

//    suspend fun getResultDetail() : Flow<ResultDomainModel>
//    suspend fun getResultsDetail() : Flow<ResultsDomainModel>
//    suspend fun getGenresDetail() : Flow<List<GenreDomainModel>>
//    suspend fun getPopularMoviesDetail() : List<ResultDomainModel>
//    suspend fun getUpComingMoviesDetail() : List<ResultDomainModel>
