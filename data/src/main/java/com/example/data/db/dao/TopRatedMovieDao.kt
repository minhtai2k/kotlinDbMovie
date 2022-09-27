package com.example.data.db.dao

import androidx.room.*
import com.example.data.db.model.ResultEntity
import com.example.data.db.model.TopRatedMovieEntity

@Dao
interface TopRatedMovieDao {
    @Query("select * from topRatedMovies")
    fun getAll(): List<ResultEntity>

    @Query("select * from topRatedMovies where pid in (:topRatedMoviesIds)")
    fun loadAllByIds(topRatedMoviesIds: IntArray): List<ResultEntity>

    @Query("select * from topRatedMovies where title like (:alphabet) limit 1")
    fun findByName(alphabet: String): ResultEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(topRatedMovies: List<TopRatedMovieEntity>)

    @Delete
    fun delete(topRatedMovie: ResultEntity)
}