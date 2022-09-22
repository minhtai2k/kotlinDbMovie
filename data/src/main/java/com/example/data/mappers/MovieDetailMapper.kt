package com.example.data.mappers

import com.example.data.models.*
import com.example.domain.models.*
import javax.inject.Inject

//class MovieDetailMapper @Inject constructor() {
//
//    private fun BelongsToCollectionDataModel.toBeLongToCollectionDetailsModel(): BelongsToCollectionDetailsModel{
//        return BelongsToCollectionDetailsModel(
//            id = id,
//            name = name,
//            poster_path = poster_path,
//            backdrop_path = backdrop_path
//        )
//    }
//
//    fun GenreDataModel.toListGenreDetailsModel(): GenreDetailsModel{
//        return GenreDetailsModel(
//            id = id,
//            name = name
//        )
//    }
//
//    private fun ProductionCompaniesDataModel.toProductionCompaniesDetailsModel(): ProductionCompaniesDetailsModel{
//        return ProductionCompaniesDetailsModel(
//            id = id,
//            logo_path = logo_path,
//            name = name,
//            original_country = original_country
//        )
//    }
//
//    private fun ProductionCountriesDataModel.toProductionCountriesDetailsModel(): ProductionCountriesDetailsModel{
//        return ProductionCountriesDetailsModel(
//            iso_3166_1 = iso_3166_1,
//            name = name
//        )
//    }
//
//    private fun SpokenLanguagesDataModel.toSpokenLanguagesDetailsModel(): SpokenLanguagesDetailsModel{
//        return SpokenLanguagesDetailsModel(
//            english_name = english_name,
//            iso_639_1 = iso_639_1,
//            name = name
//        )
//    }
//
//
//
//    fun toMovieDetail(movieDetailServer: MovieDetailDataModel) : MovieDetailsModel {
//        return MovieDetailsModel(
//            adult = adult,
//            backdrop_path = backdrop_path,
//            belongs_to_collection = belongs_to_collection!!.toBeLongToCollectionDetailsModel(),
//            budget =  budget,
////            genres = genres.map {
////                GenreDetailsModel(id = it.id, name = it.name)
////            }
//            genres = genres.map {
//                it.toListGenreDetailsModel()
//            },
//            homepage = homepage,
//            id = id,
//            imdb_id = imdb_id,
//            original_language = original_language,
//            original_title = original_title,
//            overview = overview,
//            popularity = popularity,
//            poster_path = poster_path,
//            production_companies = production_companies.map { it.toProductionCompaniesDetailsModel() },
//            production_countries = production_countries.map { it.toProductionCountriesDetailsModel() },
//            release_date = release_date,
//            revenue = revenue,
//            runtime = runtime,
//            spoken_languages = spoken_languages.map { it.toSpokenLanguagesDetailsModel() },
//            status = status,
//            tagline = tagline,
//            title = title,
//            video = video,
//            vote_average = vote_average,
//            vote_count = vote_count
//
//        )
//    }
//
//
//
////  fun toBeLongToCollectionDetail(belongToCollectionServer: BelongsToCollectionDataModel) : BelongsToCollectionDetailsModel {
////        return BelongsToCollectionDetailsModel(
////            id = belongToCollectionServer.id,
////            name = belongToCollectionServer.name,
////            poster_path = belongToCollectionServer.poster_path,
////            backdrop_path = belongToCollectionServer.backdrop_path
////        )
////    }
////  fun toGenreDetail(genreDetailServer: GenreDataModel) : GenreDetailsModel {
////    return GenreDetailsModel(
////        id = genreDetailServer.id,
////        name = genreDetailServer.name
////    )
////}
////
////    fun toGenreData(genreDetailServer: GenreDetailsModel) : GenreDataModel {
////        return GenreDataModel(
////            id = genreDetailServer.id,
////            name = genreDetailServer.name
////        )
////    }
//}

private fun BelongsToCollectionDataModel.toBeLongToCollectionDetailsModel(): BelongsToCollectionDetailsModel{
    return BelongsToCollectionDetailsModel(
        id = id,
        name = name,
        poster_path = poster_path,
        backdrop_path = backdrop_path
    )
}

fun GenreDataModel.toListGenreDetailsModel(): GenreDetailsModel{
    return GenreDetailsModel(
        id = id,
        name = name
    )
}

private fun ProductionCompaniesDataModel.toProductionCompaniesDetailsModel(): ProductionCompaniesDetailsModel{
    return ProductionCompaniesDetailsModel(
        id = id,
        logo_path = logo_path,
        name = name,
        original_country = original_country
    )
}

private fun ProductionCountriesDataModel.toProductionCountriesDetailsModel(): ProductionCountriesDetailsModel{
    return ProductionCountriesDetailsModel(
        iso_3166_1 = iso_3166_1,
        name = name
    )
}

private fun SpokenLanguagesDataModel.toSpokenLanguagesDetailsModel(): SpokenLanguagesDetailsModel{
    return SpokenLanguagesDetailsModel(
        english_name = english_name,
        iso_639_1 = iso_639_1,
        name = name
    )
}

fun MovieDetailDataModel.toMovieDetailsModel() : MovieDetailsModel {
    return MovieDetailsModel(
        adult = adult,
        backdrop_path = backdrop_path,
        belongs_to_collection = belongs_to_collection!!.toBeLongToCollectionDetailsModel(),
        budget =  budget,
//            genres = genres.map {
//                GenreDetailsModel(id = it.id, name = it.name)
//            }
        genres = genres.map {
            it.toListGenreDetailsModel()
        },
        homepage = homepage,
        id = id,
        imdb_id = imdb_id,
        original_language = original_language,
        original_title = original_title,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        production_companies = production_companies.map { it.toProductionCompaniesDetailsModel() },
        production_countries = production_countries.map { it.toProductionCountriesDetailsModel() },
        release_date = release_date,
        revenue = revenue,
        runtime = runtime,
        spoken_languages = spoken_languages.map { it.toSpokenLanguagesDetailsModel() },
        status = status,
        tagline = tagline,
        title = title,
        video = video,
        vote_average = vote_average,
        vote_count = vote_count

    )
}