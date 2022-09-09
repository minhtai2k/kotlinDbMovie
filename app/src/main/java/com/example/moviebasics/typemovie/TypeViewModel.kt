package com.example.moviebasics.typemovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviebasics.model.Results
import com.example.moviebasics.network.TypeMoviesApi
import kotlinx.coroutines.launch

class TypeViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()
    val status : LiveData<String> = _status

    private val _typeMovies = MutableLiveData<Results>()
    val typeMovies : LiveData<Results> = _typeMovies

    init {

    }

    private fun getTypeMovies(){
        viewModelScope.launch {
            try {
                _typeMovies.value = TypeMoviesApi.retrofitService.getTypeMovies()
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}