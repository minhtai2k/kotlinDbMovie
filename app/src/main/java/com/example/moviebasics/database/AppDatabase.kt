package com.example.moviebasics.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.moviebasics.database.converter.PopularMovieIdsConverter
import com.example.moviebasics.database.model.GenreEntity
import com.example.moviebasics.database.model.PopularMovieEntity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

const val DATABASE_NAME = "MovieBasicDb"

@Database(
    entities = [GenreEntity::class, PopularMovieEntity::class],
    exportSchema = true,
    version = 1,
)
//@TypeConverters(PopularMovieConverter::class)
//@Module
//@InstallIn(ActivityComponent::class)
@TypeConverters(PopularMovieIdsConverter::class)
abstract class AppDatabase : RoomDatabase() {
//    @Provides
    abstract fun genreDao(): GenreDao
    abstract fun popularMovieDao(): PopularMovieDao
}