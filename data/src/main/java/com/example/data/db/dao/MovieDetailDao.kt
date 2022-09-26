package com.example.data.db.dao

import androidx.room.*
import com.example.data.db.model.MovieDetailEntity

@Dao
interface MovieDetailDao {
    @Query("select * from detailMovies")
    fun getAll(): List<MovieDetailEntity>

    @Query("select * from detailMovies where id in (:detailMoviesIds)")
    fun loadAllByIds(detailMoviesIds: Int): MovieDetailEntity

    @Query("select * from detailMovies where title like (:alphabet) limit 1")
    fun findByName(alphabet: String): MovieDetailEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(detailMovies: MovieDetailEntity)

    @Delete
    fun delete(topRatedMovie: MovieDetailEntity)
}

