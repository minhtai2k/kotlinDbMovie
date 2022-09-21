package com.example.moviebasics.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moviebasics.model.*

@Entity(tableName = "detailMovies")
data class DetailMovieEntity (
    @ColumnInfo(name = "adult") val adult: Boolean,
    @ColumnInfo(name = "backdropPath") val backdrop_path: String?,
    @ColumnInfo(name = "belongsToCollection") val belongs_to_collection: BelongsToCollection?,
    @ColumnInfo(name = "budget") val budget: Int,
    @ColumnInfo(name = "genres") val genres: List<Genre>,
    @ColumnInfo(name = "homepage") val homepage: String,
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "imdbId") val imdb_id: String,
    @ColumnInfo(name = "originalLanguage") val original_language: String,
    @ColumnInfo(name = "originalTitle") val original_title: String,
    @ColumnInfo(name = "overview") val overview: String,
    @ColumnInfo(name = "popularity") val popularity: Double,
    @ColumnInfo(name = "posterPath") val poster_path: String,
    @ColumnInfo(name = "productionCompanies") val production_companies: List<ProductionCompanies>,
    @ColumnInfo(name = "productionCountries") val production_countries: List<ProductionCountries>,
    @ColumnInfo(name = "releaseDate") val release_date: String,
    @ColumnInfo(name = "revenue") val revenue: Int,
    @ColumnInfo(name = "runtime") val runtime: Int,
    @ColumnInfo(name = "spokenLanguages") val spoken_languages: List<SpokenLanguages>,
    @ColumnInfo(name = "status") val status: String,
    @ColumnInfo(name = "tagline") val tagline: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "video") val video: Boolean,
    @ColumnInfo(name = "voteAverage") val vote_average: Float,
    @ColumnInfo(name = "voteCount") val vote_count: Int
)

//@Entity(tableName = "belongToCollections")
//data class BeLongsToCollectionEntity(
//    val id: Int,
//    val name: String,
//    val poster_path: String,
//    val backdrop_path: String?
//)
//
//@Entity(tableName = "productionCompanies")
//data class ProductionCompanies(
//    val id: Int,
//    val logo_path: String?,
//    val name: String,
//    val original_country: String?
//)
//
//@Entity(tableName = "productionCountries")
//data class ProductionCountries(val iso_3166_1: String, val name: String)

//@Entity(tableName = "spokenLanguages")
//data class SpokenLanguages(val english_name: String, val iso_639_1: String, val name: String)