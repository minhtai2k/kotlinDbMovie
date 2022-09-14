package com.example.moviebasics.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviebasics.dao.AppDatabase
import com.example.moviebasics.dao.GenreEntity
import com.example.moviebasics.model.Genre
import com.example.moviebasics.model.Genres
import com.example.moviebasics.model.Results
import com.example.moviebasics.network.GenresApi
import com.example.moviebasics.network.PopularMovieApi
import com.example.moviebasics.network.TopRatedMovieApi
import com.example.moviebasics.network.UpcomingMovieApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _genres = MutableLiveData<Genres>()
    val genres: LiveData<Genres> = _genres

    private val _resultsUpcoming = MutableLiveData<Results>()

    //        val resultsUpcoming : LiveData<Results> = _resultsUpcoming ==> khong su dung cung duoc
    val resultsUpcoming: LiveData<Results> = _resultsUpcoming

    private val _popularMovies = MutableLiveData<Results>()
    val popularMovies: LiveData<Results> = _popularMovies

    private val _topRatedMovies = MutableLiveData<Results>()
    val topRatedMovies: LiveData<Results> = _topRatedMovies

    init {
//        getGenresList()
        getUpcomingMovieList()
        getPopularMovies()
        getTopRatedMovies()
    }

    fun getGenresList(db: AppDatabase, isConnected: Boolean) {
        val genreDao = db.genreDao()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (isConnected) {
//                _status.value = "Load data success"
//                _genres.value = GenresApi.retrofitService.getGenres()
                    _genres.postValue(GenresApi.retrofitService.getGenres())
                    genreDao.insertAll(_genres.value!!.genres.map {
                        it.toGenreEntity()
                    })
                } else {
                    val genreList: List<Genre> = genreDao.getAll().map { it.toGenre() }
                    _genres.postValue(Genres(genreList))
                }

            } catch (e: Exception) {
                _status.postValue("Failure: ${e.message}")
                Log.d("GenresList", "${e.message}")
            }
        }
    }

    private fun getUpcomingMovieList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
//                _resultsUpcoming.value = UpcomingMovieApi.retrofitService.getUpcomingMovies()
                _resultsUpcoming.postValue(UpcomingMovieApi.retrofitService.getUpcomingMovies())
            } catch (e: Exception) {
//                _status.value = "Failure: ${e.message}" ==> se bi crash ra khoi app su dung postValue
                _status.postValue("Failure: ${e.message}")
                Log.d("UpcomingMovieList", "${e.message}")
            }
        }
    }

    private fun getPopularMovies() {
        viewModelScope.launch {
            try {
//                _popularMovies.value = PopularMovieApi.retrofitService.getPopularMovies()
                _popularMovies.postValue(PopularMovieApi.retrofitService.getPopularMovies())
            } catch (e: Exception) {
//                _status.value = "Failure: ${e.message}"
                _status.postValue("Failure: ${e.message}")
                Log.d("PopularMovies", "${e.message}")
            }
        }
    }

    fun getTopRatedMovies() {
        viewModelScope.launch {
            try {
                _topRatedMovies.postValue(TopRatedMovieApi.retrofitService.getTopRatedMovies())
            } catch (e: Exception) {
//                _status.value = "Failure: ${e.message}"
                _status.postValue("Failure: ${e.message}")
            }
        }
    }

    fun Genre.toGenreEntity() = GenreEntity(
        gid = id,
        name = name
    )

    fun GenreEntity.toGenre() = Genre(
        id = gid,
        name = name
    )
}