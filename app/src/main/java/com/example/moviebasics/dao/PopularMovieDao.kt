package com.example.moviebasics.dao

import androidx.room.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

open class PopularMovieGenreIdsConverter {
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

@Entity(tableName = "popularMovies")
//@TypeConverters(PopularMovieConverter::class)
data class PopularMovieEntity(
    @ColumnInfo(name = "adult") val adult: Boolean,
    @ColumnInfo(name = "backdropPath") val backdrop_path: String?,
    @ColumnInfo(name = "genreIds") val genre_ids: List<Int>?,
    @PrimaryKey val pid: Int,
    @ColumnInfo(name = "originalLanguage") val original_language: String,
    @ColumnInfo(name = "originalTitle") val original_title: String,
    @ColumnInfo(name = "overview") val overview: String,
    @ColumnInfo(name = "popularity") val popularity: Double,
    @ColumnInfo(name = "posterPath") val poster_path: String,
    @ColumnInfo(name = "releaseDate") val release_date: String,
    @ColumnInfo(name = "title") val title : String,
    @ColumnInfo(name = "video") val video : Boolean,
    @ColumnInfo(name = "voteAverage") val vote_average : Float,
    @ColumnInfo(name = "voteCount") val vote_count : Int
)

@Dao
interface PopularMovieDao {
    @Query("select * from popularMovies")
    fun getAll(): List<PopularMovieEntity>

    @Query("select * from popularMovies where pid in (:popularMovieIds)")
    fun loadAllByIds(popularMovieIds: IntArray): List<PopularMovieEntity>

    @Query("select * from popularMovies where title like (:alphabet) limit 1")
    fun findByName(alphabet: String): PopularMovieEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(popularMovies: List<PopularMovieEntity>)

    @Delete
    fun delete(popularMovie: PopularMovieEntity)
}