package com.example.moviebasics.database.converter

import androidx.room.TypeConverter
import com.example.moviebasics.model.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module

open class MovieConverter {
    //    Moshi Converter
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    private val intType = Types.newParameterizedType(List::class.java, Int::class.javaObjectType)
    private val intAdapter = moshi.adapter<List<Int>>(intType)

    @TypeConverter
    fun listIntToString(value: List<Int>): String {
        return intAdapter.toJson(value)
    }

    @TypeConverter
    fun stringToListInt(value: String): List<Int> {
        return intAdapter.fromJson(value).orEmpty()
    }

    //  DetailMovieDao Converter
//    private val belongsToCollectionType = Types.newParameterizedType(belongs_to_collection::class.java)
    private val belongsToCollectionAdapter = moshi.adapter(belongs_to_collection::class.java)

    private val genreType = Types.newParameterizedType(List::class.java, Genre::class.java)
    private val genreAdapter = moshi.adapter<List<Genre>>(genreType)

    private val pCompaniesType = Types.newParameterizedType(List::class.java, production_companies::class.java)
    private val pCompaniesAdapter = moshi.adapter<List<production_companies>>(pCompaniesType)

    private val pCountriesType = Types.newParameterizedType(List::class.java, production_countries::class.java)
    private val pCountriesAdapter = moshi.adapter<List<production_countries>>(pCountriesType)

    private val spokenLanguageType = Types.newParameterizedType(List::class.java, spoken_languages::class.java)
    private val spokenLanguageAdapter = moshi.adapter<List<spoken_languages>>(spokenLanguageType)

    @TypeConverter
    fun belongsToCollectionToString(value: belongs_to_collection) : String {
        return belongsToCollectionAdapter.toJson(value)
    }

    @TypeConverter
    fun stringToBelongsToCollection(value: String) : belongs_to_collection? {
        return belongsToCollectionAdapter.fromJson(value)
    }

    @TypeConverter
    fun listGenreToString(value: List<Genre>) : String {
        return genreAdapter.toJson(value)
    }

    @TypeConverter
    fun stringToListGenre(value: String) : List<Genre> {
        return genreAdapter.fromJson(value).orEmpty()
    }

    @TypeConverter
    fun listPCompaniesToString(value: List<production_companies>) : String {
        return pCompaniesAdapter.toJson(value)
    }

    @TypeConverter
    fun stringToListPCompanies(value: String) : List<production_companies> {
        return pCompaniesAdapter.fromJson(value).orEmpty()
    }

    @TypeConverter
    fun listPCountriesToString(value: List<production_countries>) : String {
        return pCountriesAdapter.toJson(value)
    }

    @TypeConverter
    fun stringToListPCountries(value: String) : List<production_countries> {
        return pCountriesAdapter.fromJson(value).orEmpty()
    }

    @TypeConverter
    fun listSpokenLanguagesToString(value: List<spoken_languages>) : String {
        return spokenLanguageAdapter.toJson(value)
    }

    @TypeConverter
    fun stringToListSpokenLanguages(value: String) : List<spoken_languages> {
        return spokenLanguageAdapter.fromJson(value).orEmpty()
    }

}

//fun genreConverter(moshi: Moshi) {
//    val intType = Types.newParameterizedType(List::class.java, Int::class.javaObjectType)
//    val intAdapter = moshi.adapter<List<Int>>(intType)
//
//    @TypeConverter
//    fun listIntToString(value: List<Int>): String {
//        return intAdapter.toJson(value)
//    }
//
//    @TypeConverter
//    fun stringToListInt(value: String): List<Int> {
//        return intAdapter.fromJson(value).orEmpty()
//    }
//}

