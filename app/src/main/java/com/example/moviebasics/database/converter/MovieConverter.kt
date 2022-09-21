package com.example.moviebasics.database.converter

import androidx.room.TypeConverter
import com.example.moviebasics.model.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

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

//      DetailMovieDao Converter
    private val belongsToCollectionType = Types.newParameterizedType(List::class.java, BelongsToCollection::class.java)
    private val belongsToCollectionAdapter = moshi.adapter<BelongsToCollection>(belongsToCollectionType)

    private val genreType = Types.newParameterizedType(List::class.java, Genre::class.java)
    private val genreAdapter = moshi.adapter<List<Genre>>(genreType)

    private val pCompaniesType = Types.newParameterizedType(List::class.java, ProductionCompanies::class.java)
    private val pCompaniesAdapter = moshi.adapter<List<ProductionCompanies>>(pCompaniesType)

    private val pCountriesType = Types.newParameterizedType(List::class.java, ProductionCountries::class.java)
    private val pCountriesAdapter = moshi.adapter<List<ProductionCountries>>(pCountriesType)

    private val spokenLanguageType = Types.newParameterizedType(List::class.java, SpokenLanguages::class.java)
    private val spokenLanguageAdapter = moshi.adapter<List<SpokenLanguages>>(spokenLanguageType)

    @TypeConverter
    fun belongsToCollectionToString(value: BelongsToCollection) : String {
        return belongsToCollectionAdapter.toJson(value)
    }

    @TypeConverter
    fun stringToBelongsToCollection(value: String) : BelongsToCollection? {
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
    fun listPCompaniesToString(value: List<ProductionCompanies>) : String {
        return pCompaniesAdapter.toJson(value)
    }

    @TypeConverter
    fun stringToListPCompanies(value: String) : List<ProductionCompanies> {
        return pCompaniesAdapter.fromJson(value).orEmpty()
    }

    @TypeConverter
    fun listPCountriesToString(value: List<ProductionCountries>) : String {
        return pCountriesAdapter.toJson(value)
    }

    @TypeConverter
    fun stringToListPCountries(value: String) : List<ProductionCountries> {
        return pCountriesAdapter.fromJson(value).orEmpty()
    }

    @TypeConverter
    fun listSpokenLanguagesToString(value: List<SpokenLanguages>) : String {
        return spokenLanguageAdapter.toJson(value)
    }

    @TypeConverter
    fun stringToListSpokenLanguages(value: String) : List<SpokenLanguages> {
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

