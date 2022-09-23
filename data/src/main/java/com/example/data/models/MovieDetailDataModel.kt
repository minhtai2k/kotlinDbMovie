package com.example.data.models

data class MovieDetailDataModel(
    val adult: Boolean,
    val backdrop_path: String?,
    val belongs_to_collection: BelongsToCollectionDataModel?,
    val budget: Int,
    val genres: List<GenreDataModel>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompaniesDataModel>,
    val production_countries: List<ProductionCountriesDataModel>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguagesDataModel>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Float,
    val vote_count: Int
)

data class BelongsToCollectionDataModel(
    val id: Int,
    val name: String,
    val poster_path: String,
    val backdrop_path: String?
)

data class ProductionCompaniesDataModel(
    val id: Int,
    val logo_path: String?,
    val name: String,
    val original_country: String?
)

data class ProductionCountriesDataModel(val iso_3166_1: String, val name: String)

data class SpokenLanguagesDataModel(val english_name: String, val iso_639_1: String, val name: String)