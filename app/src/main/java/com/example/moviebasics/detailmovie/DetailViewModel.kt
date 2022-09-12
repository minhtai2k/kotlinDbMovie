package com.example.moviebasics.detailmovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviebasics.model.MovieDetail
import com.example.moviebasics.model.Results
import com.example.moviebasics.network.MovieDetailApi
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    private val _status = MutableLiveData<String>()
    val status : LiveData<String> = _status

    private val _movieDetail = MutableLiveData<MovieDetail>()
    val movieDetail : LiveData<MovieDetail> = _movieDetail

    fun getMovieDetail(id : Int){
        viewModelScope.launch {
            try {
                _movieDetail.value = MovieDetailApi.retrofitService.getMovieDetail(movieId = id)
            } catch (e: Exception) {
                _status.value = e.message
            }
        }
    }
}