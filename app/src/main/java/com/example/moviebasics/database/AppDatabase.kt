package com.example.moviebasics.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.moviebasics.database.converter.MovieConverter
import com.example.moviebasics.database.dao.*
import com.example.moviebasics.database.model.*

const val DATABASE_NAME = "MovieBasicDb"

@Database(
    entities = [GenreEntity::class, PopularMovieEntity::class, UpcomingMovieEntity::class, TopRatedMovieEntity::class, TypeMovieEntity::class, DetailMovieEntity::class],
    exportSchema = true,
    version = 4,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3),
        AutoMigration(from = 3, to = 4),
//        AutoMigration(from = 4, to = 5)
    ]
)
//@TypeConverters(PopularMovieConverter::class)
//@Module
//@InstallIn(ActivityComponent::class)
@TypeConverters(MovieConverter::class)
abstract class AppDatabase : RoomDatabase() {
    //    @Provides
    abstract fun genreDao(): GenreDao
    abstract fun popularMovieDao(): PopularMovieDao
    abstract fun upcomingMovieDao(): UpcomingMovieDao
    abstract fun topRatedMovieDao(): TopRatedMovieDao
    abstract fun typeMovieDao(): TypeMovieDao
    abstract fun detailMovieDao(): DetailMovieDao
}