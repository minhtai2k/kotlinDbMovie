package com.example.data.mappers

import com.example.data.db.model.TopRatedMovieEntity
import com.example.domain.model.ResultDomainModel

fun TopRatedMovieEntity.toResultsDomainModel(): ResultDomainModel {
    return ResultDomainModel(
        adult, backdrop_path, genre_ids, pid, original_language, original_title, overview, popularity, poster_path, release_date, title, video, vote_average, vote_count
    )
}

fun ResultDomainModel.toTopRatedMovieEntity(): TopRatedMovieEntity {
    return TopRatedMovieEntity(
        adult, backdrop_path, genre_ids, id, original_language, original_title, overview, popularity, poster_path, release_date, title, video, vote_average, vote_count
    )
}