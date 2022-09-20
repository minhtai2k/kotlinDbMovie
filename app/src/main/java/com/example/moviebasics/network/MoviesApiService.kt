package com.example.moviebasics.network

import android.content.Context
import androidx.room.Room
import com.example.moviebasics.database.AppDatabase
import com.example.moviebasics.database.DATABASE_NAME
import com.example.moviebasics.model.Genres
import com.example.moviebasics.model.MovieDetail
import com.example.moviebasics.model.Results
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton

private const val BASE_URL = "https://api.themoviedb.org/3/"
private const val API_KEY = "ac879a639703afa0f68ae199252bd055"
const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

//Genre API Connect

interface GenreApiService {
    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("api_key") apiKey: String = API_KEY
    ): Genres
}

//@Module
//@InstallIn(ActivityComponent::class)
//object GenresApi {
//    val retrofitService: GenreApiService by lazy {
//        retrofit.create(GenreApiService::class.java)
//    }
//}

@Module
@InstallIn(SingletonComponent::class)
object GenresApi {
    @Provides @Singleton fun retrofitService(): GenreApiService {
        return retrofit.create(GenreApiService::class.java)

    }
    @Provides @Singleton fun getDatabase(@ApplicationContext context: Context) : AppDatabase{
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

}

//Upcoming Movie API Connect

interface UpcomingMovieApiService {
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String = API_KEY
    ): Results
}

object UpcomingMovieApi {
    val retrofitService: UpcomingMovieApiService by lazy {
        retrofit.create(UpcomingMovieApiService::class.java)
    }
}

//Type List Movie API Connect

interface TypeMoviesApiService {
    @GET("discover/movie")
    suspend fun getTypeMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("with_genres") withGenres: Int
    ): Results
}

object TypeMoviesApi {
    val retrofitService: TypeMoviesApiService by lazy {
        retrofit.create(TypeMoviesApiService::class.java)
    }
}

//Movie Detail API Connect

interface MovieDetailApiService {
    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId : Int,
        @Query("api_key") apiKey: String = API_KEY
    ) : MovieDetail
}

object MovieDetailApi {
    val retrofitService : MovieDetailApiService by lazy {
        retrofit.create(MovieDetailApiService::class.java)
    }
}

//Popular Movie API Connect

interface PopularMovieApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies (
        @Query("api_key")api_key : String = API_KEY
    ) : Results
}

@Module
@InstallIn(SingletonComponent::class)
object PopularMovieApi {
    @Provides
    @Singleton
    fun retrofitService() : PopularMovieApiService  {
        return retrofit.create(PopularMovieApiService::class.java)
    }
    @Provides @Singleton fun getDatabase(@ApplicationContext context: Context) : AppDatabase{
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        )
            .build()
    }
}

//Top Rated Movie API Connect

interface TopRatedMovieApiService {
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key")api_key: String = API_KEY
    ) : Results
}

@Module
@InstallIn(SingletonComponent::class)
object TopRatedMovieApi {
    @Provides
    @Singleton
    fun retrofitService() : TopRatedMovieApiService {
        return retrofit.create(TopRatedMovieApiService::class.java)
    }
    @Provides @Singleton fun getDatabase(@ApplicationContext context: Context) : AppDatabase{
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        )
            .build()
    }
}

