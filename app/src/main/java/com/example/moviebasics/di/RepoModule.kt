package com.example.moviebasics.di

import android.app.Application
import android.content.Context
import com.example.data.repo.RemoteRepoImpl
import com.example.domain.repositories.RemoteRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {
//    @Binds
//    abstract fun bindContext(application: Application) : Context

    @Binds
    abstract fun bindRemoteRepo(remoteRepoImpl: RemoteRepoImpl): RemoteRepo
}

