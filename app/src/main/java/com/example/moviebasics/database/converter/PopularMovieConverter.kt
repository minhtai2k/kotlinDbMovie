package com.example.moviebasics.database.converter

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

open class PopularMovieIdsConverter {
    //    Moshi Converter
    private val moshi = Moshi.Builder().build()
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
}