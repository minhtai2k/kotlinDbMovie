package com.example.data.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.db.converter.DatabaseConverter
import com.example.data.db.dao.*
import com.example.data.db.model.GenreEntity

@Database(
    entities = [GenreEntity::class],
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
    abstract fun popularMovieDao(): PopularMovieDao
    abstract fun upcomingMovieDao(): UpcomingMovieDao
    abstract fun topRatedMovieDao(): TopRatedMovieDao
    abstract fun typeMovieDao(): TypeMovieDao
    abstract fun detailMovieDao(): DetailMovieDao
}