package com.example.moviebasics.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.moviebasics.database.converter.MovieConverter
import com.example.moviebasics.database.dao.TopRatedMovieDao
import com.example.moviebasics.database.dao.UpcomingMovieDao
import com.example.moviebasics.database.model.GenreEntity
import com.example.moviebasics.database.model.PopularMovieEntity
import com.example.moviebasics.database.model.TopRatedMovieEntity
import com.example.moviebasics.database.model.UpcomingMovieEntity

const val DATABASE_NAME = "MovieBasicDb"

@Database(
    entities = [GenreEntity::class, PopularMovieEntity::class, UpcomingMovieEntity::class, TopRatedMovieEntity::class],
    exportSchema = true,
    version = 3,
    autoMigrations = [
        AutoMigration (from = 1, to = 2),
        AutoMigration (from = 2, to = 3)
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
    abstract fun topRatedMovieDao() : TopRatedMovieDao
}