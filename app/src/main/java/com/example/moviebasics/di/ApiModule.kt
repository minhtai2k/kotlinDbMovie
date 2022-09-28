package com.example.moviebasics.di

import android.content.Context
import androidx.room.Room
import com.example.data.apiservice.ApiService
import com.example.data.db.AppDatabase
import com.example.data.utils.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    private fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    private fun provideOkHttpClient(): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
        okHttpBuilder.addInterceptor(HttpLoggingInterceptor())
        okHttpBuilder.connectTimeout(Constants.CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)
        okHttpBuilder.readTimeout(Constants.READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
        okHttpBuilder.writeTimeout(Constants.WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
        return okHttpBuilder.build()
    }

    @Provides
    fun bindApiService(): ApiService {
//        return retrofit.create(ApiService::class.java)
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(provideMoshi()))
//            .addCallAdapterFactory()
            .client(provideOkHttpClient())
            .build()
        return retrofit.create(ApiService::class.java)
    }

//    @Provides
//    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
//        return Room.databaseBuilder(
//            context,
//            AppDatabase::class.java,
//            Constants.DATABASE_NAME
//        ).build()
//    }
}

//@Module
//@InstallIn(SingletonComponent::class)

//object DataRoomApi {
//    @Provides
//    fun retrofitGenreService(): GenreApiService {
//        return retrofit.create(GenreApiService::class.java)
//    }
//
//    @Provides
//    @Singleton
//    fun retrofitUpcomingMovieService(): UpcomingMovieApiService {
//        return retrofit.create(UpcomingMovieApiService::class.java)
//    }
//
//    @Provides
//    @Singleton
//    fun retrofitTypeMovieService(): TypeMoviesApiService {
//        return retrofit.create(TypeMoviesApiService::class.java)
//    }
//
//    @Provides
//    @Singleton
//    fun retrofitMovieDetailService(): MovieDetailApiService {
//        return retrofit.create(MovieDetailApiService::class.java)
//    }
//
//    @Provides
//    @Singleton
//    fun retrofitPopularMovieService(): PopularMovieApiService {
//        return retrofit.create(PopularMovieApiService::class.java)
//    }
//
//    @Provides
//    @Singleton
//    fun retrofitTopRatedService(): TopRatedMovieApiService {
//        return retrofit.create(TopRatedMovieApiService::class.java)
//    }
//
//
//    @Provides
//    @Singleton
//    fun getDatabase(@ApplicationContext context: Context): AppDatabase {
//        return Room.databaseBuilder(
//            context,
//            AppDatabase::class.java,
//            DATABASE_NAME
//        ).build()
//    }
//
//}

