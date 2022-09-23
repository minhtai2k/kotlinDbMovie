package com.example.data.mappers

import com.example.data.models.ResultDataModel
import com.example.data.models.ResultsDataModel
import com.example.domain.model.ResultDomainModel
import com.example.domain.model.ResultsDomainModel

fun ResultDataModel.toResultDomainModel(): ResultDomainModel {
    return ResultDomainModel(
        adult, backdrop_path, genre_ids, id, original_language, original_title, overview, popularity, poster_path, release_date, title, video, vote_average, vote_count
    )
}

fun ResultsDataModel.toResultsDomainModel(): ResultsDomainModel {
    return ResultsDomainModel(
        results = results.map { it.toResultDomainModel() }
    )
}