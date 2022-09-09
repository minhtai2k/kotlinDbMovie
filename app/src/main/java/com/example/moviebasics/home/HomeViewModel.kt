package com.example.moviebasics.home

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviebasics.model.Genre
import com.example.moviebasics.model.Genres
import com.example.moviebasics.model.Results
import com.example.moviebasics.network.GenresApi
import com.example.moviebasics.network.UpcomingMovieApi
import com.example.moviebasics.network.UpcomingMovieApiService
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _genres = MutableLiveData<Genres>()
    val genres: LiveData<Genres> = _genres

    private val _resultsUpcoming = MutableLiveData<Results>()
    val resultsUpcoming = _resultsUpcoming

    init {
        getGenresList()
        getUpcomingMovieList()
    }

    private fun getGenresList() {
        viewModelScope.launch {
            try {
//                _status.value = "Load data success"
                _genres.value = GenresApi.retrofitService.getGenres()
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
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
}