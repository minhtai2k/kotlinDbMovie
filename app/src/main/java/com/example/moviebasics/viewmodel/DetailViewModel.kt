package com.example.moviebasics.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.MovieDetailDomainModel
import com.example.domain.usecases.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val modelUseCase: GetMovieDetailUseCase
) : ViewModel() {
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _movieDetail = MutableLiveData<MovieDetailDomainModel?>()
    val movieDetail: LiveData<MovieDetailDomainModel?> = _movieDetail

    fun getMovieDetail(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = modelUseCase.execute(movieId)
                _movieDetail.postValue(data)
            } catch (e: Exception) {
                _status.postValue(e.message)
                Log.d("MovieDetailViewModel", "${e.message}")
            }
        }
    }
}