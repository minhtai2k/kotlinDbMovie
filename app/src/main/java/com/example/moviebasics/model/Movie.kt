package com.example.moviebasics.model

data class MovieDetail(
    val adult: Boolean,
    val backdrop_path: String?,
    val belongs_to_collection: BelongsToCollection?,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompanies>,
    val production_countries: List<ProductionCountries>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguages>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Float,
    val vote_count: Int
)

//data class UpcomingMovie(
//    val dates: Dates,
//    val page: Int,
//    val results: List<Results>,
//    val total_pages: Int,
//    val total_result: Int
//) {
////    DI ==> Thu cong
//    latent var getResults: Results
//
//    fun getData() {
//        getResults.results
//    }
//
////    DI ==> Dagger
//
//}

//data class Dates(val maximum: Date, val minimum: Date)

data class Results(val results: List<Result>)
data class Result(
    val adult: Boolean,
    val backdrop_path: String?,
    val genre_ids: List<Int>?,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Float,
    val vote_count: Int
)

data class BelongsToCollection(
    val id: Int,
    val name: String,
    val poster_path: String,
    val backdrop_path: String?
)

data class ProductionCompanies(
    val id: Int,
    val logo_path: String?,
    val name: String,
    val original_country: String?
)

data class ProductionCountries(val iso_3166_1: String, val name: String)

data class SpokenLanguages(val english_name: String, val iso_639_1: String, val name: String)

