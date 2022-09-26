package com.example.data.db.dao

import androidx.room.*
import com.example.data.db.model.PopularMovieEntity
import com.example.data.db.model.ResultEntity

//open class PopularMovieGenreIdsConverter {
//    //    Moshi Converter
//    private val moshi = Moshi.Builder().build()
//    private val intType = Types.newParameterizedType(List::class.java, Int::class.javaObjectType)
//    private val intAdapter = moshi.adapter<List<Int>>(intType)
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

@Dao
interface PopularMovieDao {
    @Query("select * from popularMovies")
    fun getAll(): List<ResultEntity>

    @Query("select * from popularMovies where pid in (:popularMovieIds)")
    fun loadAllByIds(popularMovieIds: IntArray): List<ResultEntity>

    @Query("select * from popularMovies where title like (:alphabet) limit 1")
    fun findByName(alphabet: String): ResultEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(popularMovies: List<ResultEntity>)

    @Delete
    fun delete(popularMovie: ResultEntity)
}