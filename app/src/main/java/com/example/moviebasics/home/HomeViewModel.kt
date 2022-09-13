package com.example.moviebasics.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviebasics.model.Genres
import com.example.moviebasics.model.Results
import com.example.moviebasics.network.*
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _genres = MutableLiveData<Genres>()
    val genres: LiveData<Genres> = _genres

    private val _resultsUpcoming = MutableLiveData<Results>()
//        val resultsUpcoming : LiveData<Results> = _resultsUpcoming ==> khong su dung cung duoc
    val resultsUpcoming : LiveData<Results> = _resultsUpcoming

    private val _popularMovies = MutableLiveData<Results>()
    val popularMovies : LiveData<Results> = _popularMovies

    private val _topRatedMovies = MutableLiveData<Results>()
    val topRatedMovies : LiveData<Results> = _topRatedMovies

    init {
        getGenresList()
        getUpcomingMovieList()
        getPopularMovies()
        getTopRatedMovies()
    }

    private fun getGenresList() {
        viewModelScope.launch {
            try {
//                _status.value = "Load data success"
                _genres.value = GenresApi.retrofitService.getGenres()
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
                Log.d("GenresList", "${e.message}")
            }
        }
    }

    private fun getUpcomingMovieList() {
        viewModelScope.launch {
            try {
                _resultsUpcoming.value = UpcomingMovieApi.retrofitService.getUpcomingMovies()
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
                Log.d("UpcomingMovieList", "${e.message}")
            }
        }
    }

    private fun getPopularMovies() {
        viewModelScope.launch {
            try {
                _popularMovies.value = PopularMovieApi.retrofitService.getPopularMovies()
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
                Log.d("PopularMovies", "${e.message}")
            }
        }
    }

    private fun getTopRatedMovies() {
        viewModelScope.launch {
            try {
                _topRatedMovies.value = TopRatedMovieApi.retrofitService.getTopRatedMovies()
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}