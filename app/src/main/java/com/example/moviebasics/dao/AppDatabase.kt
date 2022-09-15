package com.example.moviebasics.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

const val DATABASE_NAME = "MovieBasicDb"

@Database(entities = [GenreEntity::class, PopularMovieEntity::class], version = 2)
//@TypeConverters(PopularMovieConverter::class)
@TypeConverters(PopularMovieGenreIdsConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun genreDao(): GenreDao
    abstract fun popularMovieDao(): PopularMovieDao
}