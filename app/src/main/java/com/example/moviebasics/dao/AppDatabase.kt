package com.example.moviebasics.dao

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

const val DATABASE_NAME = "MovieBasicDb"

@Database(entities = [GenreEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun genreDao() : GenreDao

}