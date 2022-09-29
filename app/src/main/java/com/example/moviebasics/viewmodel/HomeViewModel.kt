package com.example.moviebasics.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.GenreDomainModel
import com.example.domain.model.ResultDomainModel
import com.example.domain.usecases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val genreUseCase: GetGenresUseCase,
    private val upComingMovieUseCase: GetUpComingMoviesUseCase,
    private val popularMovieUseCase: GetPopularMoviesUseCase,
    private val topRatedMovieUseCase: GetTopRatedMoviesUseCase
) : ViewModel() {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _genres = MutableLiveData<List<GenreDomainModel>>()
    val genres: LiveData<List<GenreDomainModel>> = _genres

    private val _resultsUpcoming = MutableLiveData<List<ResultDomainModel>>()
    val resultsUpcoming: LiveData<List<ResultDomainModel>> = _resultsUpcoming

    private val _popularMovies = MutableLiveData<List<ResultDomainModel>>()
    val popularMovies: LiveData<List<ResultDomainModel>> = _popularMovies

    private val _topRatedMovies = MutableLiveData<List<ResultDomainModel>>()
    val topRatedMovies: LiveData<List<ResultDomainModel>> = _topRatedMovies


    fun getGenresList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = genreUseCase.execute()
                _genres.postValue(data)
            } catch (e: Exception) {
                _status.postValue(e.message)
                Log.d("HomeViewModel", "${e.message}")
            }
        }
    }

    fun getUpcomingMovieList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = upComingMovieUseCase.execute()
                _resultsUpcoming.postValue(data)
            } catch (e: Exception) {
                _status.postValue(e.message)
                Log.d("HomeViewModel", "${e.message}")
            }

        }
    }

    fun getPopularMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = popularMovieUseCase.execute()
                _popularMovies.postValue(data)
            } catch (e: Exception) {
                _status.postValue(e.message)
                Log.d("HomeViewModel", "${e.message}")
            }
        }
    }

    fun getTopRatedMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = topRatedMovieUseCase.execute()
                _topRatedMovies.postValue(data)
            } catch (e: Exception) {
                _status.postValue(e.message)
                Log.d("HomeViewModel", "${e.message}")
            }
        }
    }
}
