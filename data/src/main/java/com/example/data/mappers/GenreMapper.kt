package com.example.data.mappers

import com.example.data.db.model.GenreEntity
import com.example.data.db.model.GenreMovieEntity
import com.example.data.models.GenreDataModel
import com.example.domain.model.GenreDomainModel
import com.example.domain.model.ResultDomainModel

fun GenreDataModel.toGenreDomainModel(): GenreDomainModel {
    return GenreDomainModel(
        id = id,
        name = name
    )
}

fun GenreDomainModel.toGenreEntity(): GenreEntity {
    return GenreEntity(
        gid = id,
        name = name
    )
}

fun GenreMovieEntity.toResultDomainModel(): ResultDomainModel {
    return ResultDomainModel(
        adult, backdrop_path, genre_ids, pid, original_language, original_title, overview, popularity, poster_path, release_date, title, video, vote_average, vote_count
    )
}

fun ResultDomainModel.toGenreMovieEntity(): GenreMovieEntity {
    return GenreMovieEntity(
        adult, backdrop_path, genre_ids, id, original_language, original_title, overview, popularity, poster_path, release_date, title, video, vote_average, vote_count
    )
}

//fun GenresDataModel.toGenresDomainModel(): GenreListDomainModel {
//    return GenreListDomainModel(
//        genres = genres.map { it.toGenreDomainModel() }
//    )
//}

//fun GenresDomainModel.toGenresEntity(): GenresEntity {
//    return GenresEntity(
//        genres = genres.map { it.toGenreEntity() }
//    )
//}
//fun GenreDomainModel.toGenreDataModel(): GenreDataModel {
//    return GenreDataModel(
//        id = id,
//        name = name
//    )
//}

//fun GenreEntity.toGenreDataModel(): GenreDataModel {
//    return GenreDataModel(
//        id = gid,
//        name = name
//    )
//}