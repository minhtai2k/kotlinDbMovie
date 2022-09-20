package com.example.moviebasics.database

import android.content.Context
import androidx.room.*
import com.example.moviebasics.database.converter.MovieConverter
import com.example.moviebasics.database.dao.DetailMovieDao
import com.example.moviebasics.database.dao.TopRatedMovieDao
import com.example.moviebasics.database.dao.TypeMovieDao
import com.example.moviebasics.database.dao.UpcomingMovieDao
import com.example.moviebasics.database.model.*
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

const val DATABASE_NAME = "MovieBasicDb"

@Database(
    entities = [GenreEntity::class, PopularMovieEntity::class, UpcomingMovieEntity::class, TopRatedMovieEntity::class, TypeMovieEntity::class, DetailMovieEntity::class],
    exportSchema = true,
    version = 4,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3),
        AutoMigration(from = 3, to = 4)
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

@Provides
@Singleton
fun getDatabase(@ApplicationContext context: Context): AppDatabase {
    return Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        DATABASE_NAME
    ).build()
}