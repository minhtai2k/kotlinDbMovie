package com.example.data.mappers

import com.example.data.models.GenreDataModel
import com.example.domain.models.GenreDetailsModel
import javax.inject.Inject

fun GenreDataModel.toGenreDetailModel(): GenreDetailsModel {
    return GenreDetailsModel(
        id = id,
        name = name
    )
}

fun GenreDetailsModel.toGenreDataModel(): GenreDataModel {
    return GenreDataModel(
        id = id,
        name = name
    )
}