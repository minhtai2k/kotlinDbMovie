package com.example.domain.models

data class MovieDetailsModel(
    val adult: Boolean,
    val backdrop_path: String?,
    val belongs_to_collection: BelongsToCollectionDetailsModel?,
    val budget: Int,
    val genres: List<GenreDetailsModel>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompaniesDetailsModel>,
    val production_countries: List<ProductionCountriesDetailsModel>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguagesDetailsModel>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Float,
    val vote_count: Int
)

//data class Results(val results: List<Result>)
//data class Result(
//    val adult: Boolean,
//    val backdrop_path: String?,
//    val genre_ids: List<Int>?,
//    val id: Int,
//    val original_language: String,
//    val original_title: String,
//    val overview: String,
//    val popularity: Double,
//    val poster_path: String,
//    val release_date: String,
//    val title: String,
//    val video: Boolean,
//    val vote_average: Float,
//    val vote_count: Int
//)

data class BelongsToCollectionDetailsModel(
    val id: Int,
    val name: String,
    val poster_path: String,
    val backdrop_path: String?
)

data class ProductionCompaniesDetailsModel(
    val id: Int,
    val logo_path: String?,
    val name: String,
    val original_country: String?
)

data class ProductionCountriesDetailsModel(val iso_3166_1: String, val name: String)

data class SpokenLanguagesDetailsModel(val english_name: String, val iso_639_1: String, val name: String)

