package com.example.moviebasics.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genres")
data class GenreEntity(
    @PrimaryKey val gid: Int,
    @ColumnInfo(name = "name") val name: String?
)