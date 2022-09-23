package com.example.data.db.dao

import androidx.room.*
import com.example.data.db.model.DetailMovieEntity

@Dao
interface DetailMovieDao {
    @Query("select * from detailMovies")
    fun getAll(): List<DetailMovieEntity>

    @Query("select * from detailMovies where id in (:detailMoviesIds)")
    fun loadAllByIds(detailMoviesIds: Int): DetailMovieEntity

    @Query("select * from detailMovies where title like (:alphabet) limit 1")
    fun findByName(alphabet: String): DetailMovieEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(detailMovies: DetailMovieEntity)

    @Delete
    fun delete(topRatedMovie: DetailMovieEntity)
}

