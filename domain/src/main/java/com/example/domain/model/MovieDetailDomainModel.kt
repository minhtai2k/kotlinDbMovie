package com.example.domain.model

data class MovieDetailDomainModel(
    val adult: Boolean,
    val backdrop_path: String?,
    val belongs_to_collection: BelongsToCollectionDomainModel?,
    val budget: Int,
    val genres: List<GenreDomainModel>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompaniesDomainModel>,
    val production_countries: List<ProductionCountriesDomainModel>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguagesDomainModel>,
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

data class BelongsToCollectionDomainModel(
    val id: Int,
    val name: String,
    val poster_path: String,
    val backdrop_path: String?
)

data class ProductionCompaniesDomainModel(
    val id: Int,
    val logo_path: String?,
    val name: String,
    val original_country: String?
)

data class ProductionCountriesDomainModel(val iso_3166_1: String, val name: String)

data class SpokenLanguagesDomainModel(val english_name: String, val iso_639_1: String, val name: String)

