package com.example.moviebasics.di

import com.example.domain.repositories.RemoteRepo
import com.example.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGenreMovieUseCase(repo: RemoteRepo) = GetGenreMoviesUseCase(repo)

    @Provides
    fun provideGenresUseCase(repo: RemoteRepo) = GetGenreUseCase(repo)

    @Provides
    fun provideGenresListUseCase(repo: RemoteRepo) = GetGenresUseCase(repo)

    @Provides
    fun provideMovieDetailUseCase(repo: RemoteRepo) = GetMovieDetailUseCase(repo)

    @Provides
    fun providePopularMovieUseCase(repo: RemoteRepo) = GetPopularMoviesUseCase(repo)

    @Provides
    fun provideUpcomingMovieUseCase(repo: RemoteRepo) = GetUpComingMoviesUseCase(repo)

    @Provides
    fun provideTopRatedMovieUseCase(repo: RemoteRepo) = GetTopRatedMoviesUseCase(repo)

//    @Provides
//    fun provideRetrofit(okHttpClient: OkHttpClient) = NetworkModule().provideRetrofit(okHttpClient)
}