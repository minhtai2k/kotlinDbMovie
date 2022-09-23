package com.example.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "upcomingMovies")
data class UpcomingMovieEntity(
    @ColumnInfo(name = "adult") val adult: Boolean,
    @ColumnInfo(name = "backdropPath") val backdrop_path: String?,
    @ColumnInfo(name = "genreIds") val genre_ids: List<Int>?,
    @PrimaryKey val pid: Int,
    @ColumnInfo(name = "originalLanguage") val original_language: String,
    @ColumnInfo(name = "originalTitle") val original_title: String,
    @ColumnInfo(name = "overview") val overview: String,
    @ColumnInfo(name = "popularity") val popularity: Double,
    @ColumnInfo(name = "posterPath") val poster_path: String,
    @ColumnInfo(name = "releaseDate") val release_date: String,
    @ColumnInfo(name = "title") val title : String,
    @ColumnInfo(name = "video") val video : Boolean,
    @ColumnInfo(name = "voteAverage") val vote_average : Float,
    @ColumnInfo(name = "voteCount") val vote_count : Int
)