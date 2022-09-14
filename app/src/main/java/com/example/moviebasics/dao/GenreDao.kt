package com.example.moviebasics.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moviebasics.model.Genre

@Entity(tableName = "genres")
data class GenreEntity(
    @PrimaryKey val gid: Int,
    @ColumnInfo(name = "name") val name: String?
)

@Dao
interface GenreDao {
    @Query("select * from genres")
    fun getAll(): List<GenreEntity>

    @Query("select * from genres where gid in (:genreIds)")
    fun loadAllByIds(genreIds: IntArray): List<GenreEntity>

    @Query("select * from genres where name like :alphabet limit 1")
    fun findByName(alphabet: String): GenreEntity

    @Insert
    fun insertAll(vararg genres: GenreEntity)

    @Insert
    fun insertAll(genres: List<GenreEntity>)

    @Delete
    fun delete(genre: GenreEntity)
}

fun GenreEntity.toGenre() = Genre(
    id = gid,
    name = name
)
