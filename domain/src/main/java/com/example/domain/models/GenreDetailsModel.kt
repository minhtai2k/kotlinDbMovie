package com.example.domain.models

data class GenreDetailsModel(
    val id: Int,
    val name: String?
)

data class GenresDetailsModel(
    val genres: List<GenreDetailsModel>
)