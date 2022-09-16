package com.example.moviebasics.repository

import com.example.moviebasics.model.Genre
import kotlinx.coroutines.flow.Flow

class GenreRepository (
    private val genreDataSource : GenreDataSource,
    private val genreData : Genre
) {
   val genreLatestData : Flow<List<Genre>> =
       genreDataSource.latestMessages
}