package com.example.moviebasics.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moviebasics.dao.GenreEntity

data class Genres(val genres: List<Genre>)
data class Genre(val id: Int, val name: String?)

data class GenreRecord(val id: Int, val name: String){
    object ModelMapper {
        fun from(form: Genre) =
            form.name?.let { GenreRecord(form.id, it) }
    }
}