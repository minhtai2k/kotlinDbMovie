package com.example.data.db.dao

import androidx.room.*
import com.example.data.db.model.TypeMovieEntity

@Dao
interface TypeMovieDao {
    @Query("select * from typeMovies")
    fun getAll(): List<TypeMovieEntity>

    @Query("select * from typeMovies where pid in (:typeMoviesIds)")
    fun loadAllByIds(typeMoviesIds: IntArray): List<TypeMovieEntity>

    @Query("select * from typeMovies where title like (:alphabet) limit 1")
    fun findByName(alphabet: String): TypeMovieEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(typeMovies: List<TypeMovieEntity>)

    @Delete
    fun delete(topRatedMovie: TypeMovieEntity)
}