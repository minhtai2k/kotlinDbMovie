package com.example.moviebasics.di

import android.content.Context
import androidx.room.Room
import com.example.data.utils.Constants.DATABASE_NAME
import com.example.data.db.AppDatabase
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Provides
@Singleton
fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
    return Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        DATABASE_NAME
    ).build()
}