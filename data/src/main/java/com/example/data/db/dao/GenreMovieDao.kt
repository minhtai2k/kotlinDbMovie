package com.example.data.db.dao

import androidx.room.*
import com.example.data.db.model.GenreMovieEntity
import com.example.data.db.model.ResultEntity

@Dao
interface GenreMovieDao {
    @Query("select * from typeMovies")
    fun getAll(): List<GenreMovieEntity>

    @Query("select * from typeMovies where pid in (:typeMoviesIds)")
    fun loadAllByIds(typeMoviesIds: IntArray): List<GenreMovieEntity>

    @Query("select * from typeMovies where title like (:alphabet) limit 1")
    fun findByName(alphabet: String): GenreMovieEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(typeMovies: List<GenreMovieEntity>)

    @Delete
    fun delete(topRatedMovie: GenreMovieEntity)
}