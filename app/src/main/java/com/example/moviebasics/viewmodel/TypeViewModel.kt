package com.example.moviebasics.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.ResultDomainModel
import com.example.domain.usecases.GetGenreMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TypeViewModel @Inject constructor(
    private val genreMoviesUseCase: GetGenreMoviesUseCase,
) : ViewModel() {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _typeMovies = MutableLiveData<List<ResultDomainModel>>()
    val typeMovies: LiveData<List<ResultDomainModel>> = _typeMovies

    fun getTypeMovies(genreId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = genreMoviesUseCase.execute(genreId)
                _typeMovies.postValue(data)
            } catch (e: Exception) {
                _status.postValue(e.message)
            }
        }
    }
}