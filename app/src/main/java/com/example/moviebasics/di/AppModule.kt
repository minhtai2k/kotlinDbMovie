package com.example.moviebasics.di

import android.app.Application
import android.content.Context
import dagger.Binds

abstract class AppModule {
    @Binds
    abstract fun bindContext(application: Application) : Context
}