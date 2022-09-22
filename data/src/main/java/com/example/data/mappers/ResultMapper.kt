package com.example.data.mappers

import com.example.data.models.ResultDataModel
import com.example.data.models.ResultsDataModel
import com.example.domain.models.ResultDetailsModel
import com.example.domain.models.ResultsDetailsModel

fun ResultDataModel.toResultDetailsModel(): ResultDetailsModel {
    return ResultDetailsModel(
        adult, backdrop_path, genre_ids, id, original_language, original_title, overview, popularity, poster_path, release_date, title, video, vote_average, vote_count
    )
}

fun ResultsDataModel.toResultsDetailsModel(): ResultsDetailsModel {
    return ResultsDetailsModel(
        results = results.map { it.toResultDetailsModel() }
    )
}