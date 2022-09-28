package com.example.data.mappers

import com.example.data.db.model.ResultEntity
import com.example.data.db.model.UpcomingMovieEntity
import com.example.data.models.ResultDataModel
import com.example.domain.model.ResultDomainModel
//import com.example.domain.model.ResultsDomainModel

fun ResultDataModel.toResultDomainModel(): ResultDomainModel {
    return ResultDomainModel(
        adult, backdrop_path, genre_ids, id, original_language, original_title, overview, popularity, poster_path, release_date, title, video, vote_average, vote_count
    )
}

//Result Entity Mapper
fun ResultEntity.toResultDomainModel(): ResultDomainModel {
    return ResultDomainModel(
        adult, backdrop_path, genre_ids, pid, original_language, original_title, overview, popularity, poster_path, release_date, title, video, vote_average, vote_count
    )
}
fun ResultEntity.toResultDataModel(): ResultDataModel {
    return ResultDataModel(
        adult, backdrop_path, genre_ids, pid, original_language, original_title, overview, popularity, poster_path, release_date, title, video, vote_average, vote_count
    )
}

