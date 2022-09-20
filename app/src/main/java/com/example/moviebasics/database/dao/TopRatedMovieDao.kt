package com.example.moviebasics.database.dao

import androidx.room.*
import com.example.moviebasics.database.model.TopRatedMovieEntity

@Dao
interface TopRatedMovieDao {
    @Query("select * from topRatedMovies")
    fun getAll(): List<TopRatedMovieEntity>

    @Query("select * from topRatedMovies where pid in (:topRatedMoviesIds)")
    fun loadAllByIds(topRatedMoviesIds: IntArray): List<TopRatedMovieEntity>

    @Query("select * from topRatedMovies where title like (:alphabet) limit 1")
    fun findByName(alphabet: String): TopRatedMovieEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(topRatedMovies: List<TopRatedMovieEntity>)

    @Delete
    fun delete(topRatedMovie: TopRatedMovieEntity)
}