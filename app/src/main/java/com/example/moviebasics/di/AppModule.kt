package com.example.moviebasics.di

import android.app.Application
import android.content.Context
import com.example.data.repo.DataRepository
import com.example.domain.repositories.AppRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    abstract fun bindContext(application: Application) : Context

    @Binds
    abstract fun bindAppRepo(dataRepository: DataRepository) : AppRepo
}