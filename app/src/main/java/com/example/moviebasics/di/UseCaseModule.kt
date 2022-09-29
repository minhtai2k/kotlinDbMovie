package com.example.moviebasics.di

import com.example.domain.repositories.AppRepo
import com.example.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGenreMovieUseCase(repo: AppRepo) = GetGenreMoviesUseCase(repo)

    @Provides
    fun provideGenresListUseCase(repo: AppRepo) = GetGenresUseCase(repo)

    @Provides
    fun provideMovieDetailUseCase(repo: AppRepo) = GetMovieDetailUseCase(repo)

    @Provides
    fun providePopularMovieUseCase(repo: AppRepo) = GetPopularMoviesUseCase(repo)

    @Provides
    fun provideUpcomingMovieUseCase(repo: AppRepo) = GetUpComingMoviesUseCase(repo)

    @Provides
    fun provideTopRatedMovieUseCase(repo: AppRepo) = GetTopRatedMoviesUseCase(repo)
}