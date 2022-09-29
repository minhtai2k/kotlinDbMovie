package com.example.moviebasics.di

import com.example.data.repo.RemoteRepo
import com.example.data.repo.RemoteRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {
    @Binds
    abstract fun bindRemoteRepo(remoteRepoImpl: RemoteRepoImpl): RemoteRepo
}

