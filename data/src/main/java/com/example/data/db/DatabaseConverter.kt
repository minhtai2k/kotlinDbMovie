package com.example.data.db.converter

import androidx.room.TypeConverter
import com.example.data.db.model.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

open class DatabaseConverter {
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
//    private val belongsToCollectionType = Types.newParameterizedType(List::class.java, BeLongsToCollectionEntity::class.java)
    private val belongsToCollectionAdapter = moshi.adapter(BeLongsToCollectionEntity::class.java)

    private val genreType = Types.newParameterizedType(List::class.java, GenreEntity::class.java)
    private val genreAdapter = moshi.adapter<List<GenreEntity>>(genreType)

    private val pCompaniesType = Types.newParameterizedType(List::class.java, ProductionCompaniesEntity::class.java)
    private val pCompaniesAdapter = moshi.adapter<List<ProductionCompaniesEntity>>(pCompaniesType)

    private val pCountriesType = Types.newParameterizedType(List::class.java, ProductionCountriesEntity::class.java)
    private val pCountriesAdapter = moshi.adapter<List<ProductionCountriesEntity>>(pCountriesType)

    private val spokenLanguageType = Types.newParameterizedType(List::class.java, SpokenLanguagesEntity::class.java)
    private val spokenLanguageAdapter = moshi.adapter<List<SpokenLanguagesEntity>>(spokenLanguageType)

    @TypeConverter
    fun belongsToCollectionToString(value: BeLongsToCollectionEntity?) : String? {
        return belongsToCollectionAdapter.toJson(value)
    }

    @TypeConverter
    fun stringToBelongsToCollection(value: String) : BeLongsToCollectionEntity? {
        return belongsToCollectionAdapter.fromJson(value)
    }

    @TypeConverter
    fun listGenreToString(value: List<GenreEntity>) : String {
        return genreAdapter.toJson(value)
    }

    @TypeConverter
    fun stringToListGenre(value: String) : List<GenreEntity> {
        return genreAdapter.fromJson(value).orEmpty()
    }

    @TypeConverter
    fun listPCompaniesToString(value: List<ProductionCompaniesEntity>) : String {
        return pCompaniesAdapter.toJson(value)
    }

    @TypeConverter
    fun stringToListPCompanies(value: String) : List<ProductionCompaniesEntity> {
        return pCompaniesAdapter.fromJson(value).orEmpty()
    }

    @TypeConverter
    fun listPCountriesToString(value: List<ProductionCountriesEntity>) : String {
        return pCountriesAdapter.toJson(value)
    }

    @TypeConverter
    fun stringToListPCountries(value: String) : List<ProductionCountriesEntity> {
        return pCountriesAdapter.fromJson(value).orEmpty()
    }

    @TypeConverter
    fun listSpokenLanguagesToString(value: List<SpokenLanguagesEntity>) : String {
        return spokenLanguageAdapter.toJson(value)
    }

    @TypeConverter
    fun stringToListSpokenLanguages(value: String) : List<SpokenLanguagesEntity> {
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

