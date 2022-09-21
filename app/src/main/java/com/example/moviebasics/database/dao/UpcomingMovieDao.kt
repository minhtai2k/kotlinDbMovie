package com.example.moviebasics.database.dao

import androidx.room.*
import com.example.moviebasics.database.model.UpcomingMovieEntity

@Dao
interface UpcomingMovieDao {
    @Query("select * from upcomingMovies")
    fun getAll(): List<UpcomingMovieEntity>

    @Query("select * from upcomingMovies where pid in (:upcomingMovieIds)")
    fun loadAllByIds(upcomingMovieIds: IntArray): List<UpcomingMovieEntity>

    @Query("select * from upcomingMovies where title like (:alphabet) limit 1")
    fun findByName(alphabet: String): UpcomingMovieEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(upcomingMovies: List<UpcomingMovieEntity>)

    @Delete
    fun delete(upcomingMovie: UpcomingMovieEntity)
}