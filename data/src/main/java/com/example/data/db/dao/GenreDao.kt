package com.example.data.db.dao

import androidx.room.*
import com.example.data.db.model.GenreEntity

@Dao
interface GenreDao {
    @Query("select * from genres")
    fun getAll(): List<GenreEntity>

    @Query("select * from genres where gid in (:genreIds)")
    fun loadAllByIds(genreIds: IntArray): List<GenreEntity>

    @Query("select * from genres where name like :alphabet limit 1")
    fun findByName(alphabet: String): GenreEntity

//    @Insert
//    fun insertAll(vararg genres: GenreEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(genres: List<GenreEntity>)

    @Delete
    fun delete(genre: GenreEntity)
}

