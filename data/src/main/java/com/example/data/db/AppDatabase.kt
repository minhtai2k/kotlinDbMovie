package com.example.data.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.db.converter.DatabaseConverter
import com.example.data.db.dao.*
import com.example.data.db.model.*

@Database(
    entities = [GenreEntity::class, MovieDetailEntity::class, GenreMovieEntity::class, UpcomingMovieEntity::class, PopularMovieEntity::class, TopRatedMovieEntity::class],
    exportSchema = true,
    version = 4,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3),
        AutoMigration(from = 3, to = 4),
//        AutoMigration(from = 4, to = 5)
    ]
)
@TypeConverters(DatabaseConverter::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun genreDao(): GenreDao
    abstract fun movieDetailDao(): MovieDetailDao
    abstract fun genreMoviesDao(): GenreMovieDao
    abstract fun upcomingMoviesDao(): UpcomingMovieDao
    abstract fun popularMoviesDao(): PopularMovieDao
    abstract fun topRatedMoviesDao(): TopRatedMovieDao
}