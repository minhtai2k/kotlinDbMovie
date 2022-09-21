package com.example.moviebasics.database.dao

import androidx.room.*
import com.example.moviebasics.database.model.GenreEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GenreDao {
    @Query("select * from genres")
    fun getAll(): Flow<List<GenreEntity>>

    @Query("select * from genres where gid in (:genreIds)")
    fun loadAllByIds(genreIds: IntArray): Flow<List<GenreEntity>>

    @Query("select * from genres where name like :alphabet limit 1")
    fun findByName(alphabet: String): Flow<GenreEntity>

//    @Insert
//    fun insertAll(vararg genres: GenreEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(genres: List<GenreEntity>)

    @Delete
    fun delete(genre: GenreEntity)
}

