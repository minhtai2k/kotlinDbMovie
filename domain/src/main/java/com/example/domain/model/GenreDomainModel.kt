package com.example.domain.model

data class GenreDomainModel(
    val id: Int,
    val name: String?
)

data class GenreListDomainModel(
    val genres: List<GenreDomainModel>
)