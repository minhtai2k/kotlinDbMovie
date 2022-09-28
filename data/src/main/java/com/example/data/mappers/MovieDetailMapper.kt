package com.example.data.mappers

import com.example.data.db.model.*
import com.example.data.models.*
import com.example.domain.model.*

private fun BelongsToCollectionDataModel.toBeLongToCollectionDomainModel(): BelongsToCollectionDomainModel{
    return BelongsToCollectionDomainModel(
        id = id,
        name = name,
        poster_path = poster_path,
        backdrop_path = backdrop_path
    )
}
private fun BelongsToCollectionDomainModel.toBeLongToCollectionEntity(): BeLongsToCollectionEntity{
    return BeLongsToCollectionEntity(
        id = id,
        name = name,
        poster_path = poster_path,
        backdrop_path = backdrop_path
    )
}
private fun BeLongsToCollectionEntity.toBeLongToCollectionDomainModel(): BelongsToCollectionDomainModel{
    return BelongsToCollectionDomainModel(
        id = id,
        name = name,
        poster_path = poster_path,
        backdrop_path = backdrop_path
    )
}


fun GenreDataModel.toListGenreDomainModel(): GenreDomainModel{
    return GenreDomainModel(
        id = id,
        name = name
    )
}
fun GenreDomainModel.toListGenreEntity(): GenreEntity{
    return GenreEntity(
        gid = id,
        name = name
    )
}
fun GenreEntity.toListGenreDomainModel(): GenreDomainModel{
    return GenreDomainModel(
        id = gid,
        name = name
    )
}

//ProductionCompanies
private fun ProductionCompaniesDataModel.toProductionCompaniesDomainModel(): ProductionCompaniesDomainModel{
    return ProductionCompaniesDomainModel(
        id = id,
        logo_path = logo_path,
        name = name,
        original_country = original_country
    )
}
private fun ProductionCompaniesDomainModel.toProductionCompaniesEntity(): ProductionCompaniesEntity{
    return ProductionCompaniesEntity(
        id = id,
        logo_path = logo_path,
        name = name,
        original_country = original_country
    )
}
private fun ProductionCompaniesEntity.toProductionCompaniesDomainModel(): ProductionCompaniesDomainModel{
    return ProductionCompaniesDomainModel(
        id = id,
        logo_path = logo_path,
        name = name,
        original_country = original_country
    )
}

private fun ProductionCountriesDataModel.toProductionCountriesDomainModel(): ProductionCountriesDomainModel{
    return ProductionCountriesDomainModel(
        iso_3166_1 = iso_3166_1,
        name = name
    )
}
private fun ProductionCountriesDomainModel.toProductionCountriesEntity(): ProductionCountriesEntity{
    return ProductionCountriesEntity(
        iso_3166_1 = iso_3166_1,
        name = name
    )
}
private fun ProductionCountriesEntity.toProductionCountriesDomainModel(): ProductionCountriesDomainModel{
    return ProductionCountriesDomainModel(
        iso_3166_1 = iso_3166_1,
        name = name
    )
}


private fun SpokenLanguagesDataModel.toSpokenLanguagesDomainModel(): SpokenLanguagesDomainModel{
    return SpokenLanguagesDomainModel(
        english_name = english_name,
        iso_639_1 = iso_639_1,
        name = name
    )
}
private fun SpokenLanguagesDomainModel.toSpokenLanguagesEntity(): SpokenLanguagesEntity{
    return SpokenLanguagesEntity(
        english_name = english_name,
        iso_639_1 = iso_639_1,
        name = name
    )
}
private fun SpokenLanguagesEntity.toSpokenLanguagesDomainModel(): SpokenLanguagesDomainModel{
    return SpokenLanguagesDomainModel(
        english_name = english_name,
        iso_639_1 = iso_639_1,
        name = name
    )
}

fun MovieDetailDataModel.toMovieDomainModel() : MovieDetailDomainModel {
    return MovieDetailDomainModel(
        adult = adult,
        backdrop_path = backdrop_path,
        belongs_to_collection = belongs_to_collection?.toBeLongToCollectionDomainModel(),
        budget =  budget,
//            genres = genres.map {
//                GenreDomainModel(id = it.id, name = it.name)
//            }
        genres = genres.map {
            it.toListGenreDomainModel()
        },
        homepage = homepage,
        id = id,
        imdb_id = imdb_id,
        original_language = original_language,
        original_title = original_title,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        production_companies = production_companies.map { it.toProductionCompaniesDomainModel() },
        production_countries = production_countries.map { it.toProductionCountriesDomainModel() },
        release_date = release_date,
        revenue = revenue,
        runtime = runtime,
        spoken_languages = spoken_languages.map { it.toSpokenLanguagesDomainModel() },
        status = status,
        tagline = tagline,
        title = title,
        video = video,
        vote_average = vote_average,
        vote_count = vote_count

    )
}

fun MovieDetailDomainModel.toMovieDetailEntity() : MovieDetailEntity {
    return MovieDetailEntity(
        adult = adult,
        backdrop_path = backdrop_path,
        belongs_to_collection = belongs_to_collection?.toBeLongToCollectionEntity(),
        budget =  budget,
//            genres = genres.map {
//                GenreDomainModel(id = it.id, name = it.name)
//            }
        genres = genres.map {
            it.toListGenreEntity()
        },
        homepage = homepage,
        id = id,
        imdb_id = imdb_id,
        original_language = original_language,
        original_title = original_title,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        production_companies = production_companies.map { it.toProductionCompaniesEntity() },
        production_countries = production_countries.map { it.toProductionCountriesEntity() },
        release_date = release_date,
        revenue = revenue,
        runtime = runtime,
        spoken_languages = spoken_languages.map { it.toSpokenLanguagesEntity() },
        status = status,
        tagline = tagline,
        title = title,
        video = video,
        vote_average = vote_average,
        vote_count = vote_count

    )
}

//fun MovieDetailDomainModel.toMovieDetailEntity() : MovieDetailEntity {
//    return MovieDetailEntity(
//        adult = adult,
//        backdrop_path = backdrop_path,
//        belongs_to_collection = belongs_to_collection!!.toBeLongToCollectionEntity(),
//        budget =  budget,
////            genres = genres.map {
////                GenreDomainModel(id = it.id, name = it.name)
////            }
//        genres = genres.map {
//            it.toListGenreEntity()
//        },
//        homepage = homepage,
//        id = id,
//        imdb_id = imdb_id,
//        original_language = original_language,
//        original_title = original_title,
//        overview = overview,
//        popularity = popularity,
//        poster_path = poster_path,
//        production_companies = production_companies.map { it.toProductionCompaniesEntity() },
//        production_countries = production_countries.map { it.toProductionCountriesEntity() },
//        release_date = release_date,
//        revenue = revenue,
//        runtime = runtime,
//        spoken_languages = spoken_languages.map { it.toSpokenLanguagesEntity() },
//        status = status,
//        tagline = tagline,
//        title = title,
//        video = video,
//        vote_average = vote_average,
//        vote_count = vote_count
//
//    )
//}

fun MovieDetailEntity.toMovieDetailDomainModel(): MovieDetailDomainModel? {
    return MovieDetailDomainModel(
        adult = adult,
        backdrop_path = backdrop_path,
        belongs_to_collection = belongs_to_collection?.toBeLongToCollectionDomainModel(),
        budget =  budget,
//            genres = genres.map {
//                GenreDomainModel(id = it.id, name = it.name)
//            }
        genres = genres.map {
            it.toListGenreDomainModel()
        },
        homepage = homepage,
        id = id,
        imdb_id = imdb_id,
        original_language = original_language,
        original_title = original_title,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        production_companies = production_companies.map { it.toProductionCompaniesDomainModel() },
        production_countries = production_countries.map { it.toProductionCountriesDomainModel() },
        release_date = release_date,
        revenue = revenue,
        runtime = runtime,
        spoken_languages = spoken_languages.map { it.toSpokenLanguagesDomainModel() },
        status = status,
        tagline = tagline,
        title = title,
        video = video,
        vote_average = vote_average,
        vote_count = vote_count

    )
}

//fun ResultsDomainModel.toListGenreDomainModel(): GenreDomainModel{
//    return GenreDomainModel(
//        id = id,
//        name = name
//    )
//}

//class MovieDetailMapper @Inject constructor() {
//
//    private fun BelongsToCollectionDataModel.toBeLongToCollectionDomainModel(): BelongsToCollectionDomainModel{
//        return BelongsToCollectionDomainModel(
//            id = id,
//            name = name,
//            poster_path = poster_path,
//            backdrop_path = backdrop_path
//        )
//    }
//
//    fun GenreDataModel.toListGenreDomainModel(): GenreDomainModel{
//        return GenreDomainModel(
//            id = id,
//            name = name
//        )
//    }
//
//    private fun ProductionCompaniesDataModel.toProductionCompaniesDomainModel(): ProductionCompaniesDomainModel{
//        return ProductionCompaniesDomainModel(
//            id = id,
//            logo_path = logo_path,
//            name = name,
//            original_country = original_country
//        )
//    }
//
//    private fun ProductionCountriesDataModel.toProductionCountriesDomainModel(): ProductionCountriesDomainModel{
//        return ProductionCountriesDomainModel(
//            iso_3166_1 = iso_3166_1,
//            name = name
//        )
//    }
//
//    private fun SpokenLanguagesDataModel.toSpokenLanguagesDomainModel(): SpokenLanguagesDomainModel{
//        return SpokenLanguagesDomainModel(
//            english_name = english_name,
//            iso_639_1 = iso_639_1,
//            name = name
//        )
//    }
//
//
//
//    fun toMovieDetail(movieDomainerver: MovieDetailDataModel) : MovieDomainModel {
//        return MovieDomainModel(
//            adult = adult,
//            backdrop_path = backdrop_path,
//            belongs_to_collection = belongs_to_collection!!.toBeLongToCollectionDomainModel(),
//            budget =  budget,
////            genres = genres.map {
////                GenreDomainModel(id = it.id, name = it.name)
////            }
//            genres = genres.map {
//                it.toListGenreDomainModel()
//            },
//            homepage = homepage,
//            id = id,
//            imdb_id = imdb_id,
//            original_language = original_language,
//            original_title = original_title,
//            overview = overview,
//            popularity = popularity,
//            poster_path = poster_path,
//            production_companies = production_companies.map { it.toProductionCompaniesDomainModel() },
//            production_countries = production_countries.map { it.toProductionCountriesDomainModel() },
//            release_date = release_date,
//            revenue = revenue,
//            runtime = runtime,
//            spoken_languages = spoken_languages.map { it.toSpokenLanguagesDomainModel() },
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
////  fun toBeLongToCollectionDetail(belongToCollectionServer: BelongsToCollectionDataModel) : BelongsToCollectionDomainModel {
////        return BelongsToCollectionDomainModel(
////            id = belongToCollectionServer.id,
////            name = belongToCollectionServer.name,
////            poster_path = belongToCollectionServer.poster_path,
////            backdrop_path = belongToCollectionServer.backdrop_path
////        )
////    }
////  fun toGenreDetail(genreDomainerver: GenreDataModel) : GenreDomainModel {
////    return GenreDomainModel(
////        id = genreDomainerver.id,
////        name = genreDomainerver.name
////    )
////}
////
////    fun toGenreData(genreDomainerver: GenreDomainModel) : GenreDataModel {
////        return GenreDataModel(
////            id = genreDomainerver.id,
////            name = genreDomainerver.name
////        )
////    }
//}