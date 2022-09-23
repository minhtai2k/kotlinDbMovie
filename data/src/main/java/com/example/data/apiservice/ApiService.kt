package com.example.data.apiservice

import androidx.lifecycle.LiveData
import com.example.data.utils.Constants.API_KEY
import com.example.data.models.GenreDataModel
import com.example.data.models.MovieDetailDataModel
import com.example.data.models.ResultDataModel
import com.example.data.models.ResultsDataModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/upcoming")
    suspend fun getUpcomingMovieDetails(
        @Query("api_key") apiKey: String = API_KEY
    ): Flow<List<ResultDataModel>>

    @GET("genre/movie/list")
    suspend fun getGenresDetails(
        @Query("api_key") apiKey: String = API_KEY
    ): Flow<List<GenreDataModel>>

    @GET("movie/popular")
    suspend fun getPopularMovieDetails(
        @Query("api_key") api_key: String = API_KEY
    ): Flow<List<ResultDataModel>>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovieDetails(
        @Query("api_key") api_key: String = API_KEY
    ): Flow<List<ResultDataModel>>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): Flow<MovieDetailDataModel>

    @GET("discover/movie")
    suspend fun getGenreMoviesDetail(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("with_genres") withGenres: Int
    ): Flow<List<ResultDataModel>>

//    @GET("genre/movie/list")
//    suspend fun getGenresDetails(
//    ): Flow<List<GenreDataModel>>

//    @GET("movie/popular")
//    suspend fun getPopularMovieDetails(
//        @Query("api_key") api_key: String = API_KEY
//    ): Flow<List<ResultDataModel>>

//    interface UpcomingMovieApiService {
//        @GET("movie/upcoming")
//        suspend fun getUpcomingMovies(
//            @Query("api_key") apiKey: String = API_KEY
//        ): LiveData<ResultDataModel>
//    }
//
//    interface GenreApiService {
//        @GET("genre/movie/list")
//        suspend fun getGenres(
//            @Query("api_key") apiKey: String = API_KEY
//        ): LiveData<List<GenreDataModel>>
//    }
//
//    interface PopularMovieApiService {
//        @GET("movie/popular")
//        suspend fun getPopularMovies(
//            @Query("api_key") api_key: String = API_KEY
//        ): LiveData<List<ResultDataModel>>
//    }
//
//    interface TopRatedMovieApiService {
//        @GET("movie/top_rated")
//        suspend fun getTopRatedMovies(
//            @Query("api_key") api_key: String = API_KEY
//        ): LiveData<List<ResultDataModel>>
//    }
}