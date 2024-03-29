package com.example.data.apiservice

import com.example.data.models.*
import com.example.data.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("genre/movie/list")
    suspend fun getGenresDetail(
        @Query("api_key") apiKey: String = API_KEY
    ): GenresDataModel

    @GET("movie/top_rated")
    suspend fun getTopRatedMoviesDetail(
        @Query("api_key") api_key: String = API_KEY
    ): ResultsDataModel

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): MovieDetailDataModel

    @GET("discover/movie")
    suspend fun getGenreMoviesDetail(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("with_genres") withGenres: Int
    ): ResultsDataModel

//    @GET("genre/movie/list")
//    suspend fun getGenresListDetails(
//        @Query("api_key") apiKey: String = API_KEY
//    ): GenresDataModel

    @GET("movie/popular")
    suspend fun getPopularMoviesDetail(
        @Query("api_key") api_key: String = API_KEY
    ): ResultsDataModel

    @GET("movie/upcoming")
    suspend fun getUpcomingMoviesDetail(
        @Query("api_key") apiKey: String = API_KEY
    ): ResultsDataModel

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