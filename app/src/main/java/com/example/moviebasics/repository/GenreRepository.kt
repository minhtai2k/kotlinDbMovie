package com.example.moviebasics.repository

import com.example.moviebasics.network.GenreApiService

class GenreRepository(
    private val localDataSource: GenreLocalDataSource,
    private val remoteDataSource: GenreRemoteDataSource
) {

}

class GenreLocalDataSource {}
class GenreRemoteDataSource(private val loginService: GenreApiService) {

}