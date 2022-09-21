package com.example.moviebasics.model

data class Genres(val genres: List<Genre>)
data class Genre(val id: Int, val name: String?)

//data class GenreRecord(val id: Int, val name: String){
//    object ModelMapper {
//        fun from(form: Genre) =
//            form.name?.let { GenreRecord(form.id, it) }
//    }
//}