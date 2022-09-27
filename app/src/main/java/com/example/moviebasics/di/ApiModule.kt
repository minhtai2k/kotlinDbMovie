package com.example.moviebasics.di

import android.content.Context
import androidx.room.Room
import com.example.data.apiservice.ApiService
import com.example.data.db.AppDatabase
import com.example.data.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class ApiModule {
    @Provides
    fun bindApiService(retrofit: Retrofit): ApiService {
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

