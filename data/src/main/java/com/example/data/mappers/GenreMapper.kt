package com.example.data.mappers

import com.example.data.models.GenreDataModel
import com.example.domain.model.GenreDomainModel

fun GenreDataModel.toGenreDetailModel(): GenreDomainModel {
    return GenreDomainModel(
        id = id,
        name = name
    )
}

fun GenreDomainModel.toGenreDataModel(): GenreDataModel {
    return GenreDataModel(
        id = id,
        name = name
    )
}