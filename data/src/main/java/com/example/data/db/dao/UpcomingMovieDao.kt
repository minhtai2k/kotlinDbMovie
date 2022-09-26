package com.example.data.db.dao

import androidx.room.*
import com.example.data.db.model.ResultEntity
import com.example.data.db.model.UpcomingMovieEntity

//@Dao
//interface UpcomingMovieDao {
//    @Query("select * from upcomingMovies")
//    fun getAll(): List<UpcomingMovieEntity>
//
//    @Query("select * from upcomingMovies where pid in (:upcomingMovieIds)")
//    fun loadAllByIds(upcomingMovieIds: IntArray): List<UpcomingMovieEntity>
//
//    @Query("select * from upcomingMovies where title like (:alphabet) limit 1")
//    fun findByName(alphabet: String): UpcomingMovieEntity
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    fun insertAll(upcomingMovies: List<UpcomingMovieEntity>)
//
//    @Delete
//    fun delete(upcomingMovie: UpcomingMovieEntity)
//}

@Dao
interface UpcomingMovieDao {
    @Query("select * from upcomingMovies")
    fun getAll(): List<ResultEntity>

    @Query("select * from upcomingMovies where pid in (:upcomingMovieIds)")
    fun loadAllByIds(upcomingMovieIds: IntArray): List<ResultEntity>

    @Query("select * from upcomingMovies where title like (:alphabet) limit 1")
    fun findByName(alphabet: String): ResultEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(upcomingMovies: List<ResultEntity>)

    @Delete
    fun delete(upcomingMovie: ResultEntity)
}