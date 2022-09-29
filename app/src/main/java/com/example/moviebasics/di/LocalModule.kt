package com.example.moviebasics.di

import com.example.data.repo.LocalRepo
import com.example.data.repo.LocalRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalModule {
    @Binds
    abstract fun bindLocalRepo(localRepoImpl: LocalRepoImpl): LocalRepo
}