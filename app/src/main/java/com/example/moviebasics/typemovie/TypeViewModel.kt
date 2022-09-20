package com.example.moviebasics.typemovie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviebasics.database.AppDatabase
import com.example.moviebasics.model.Results
import com.example.moviebasics.network.TypeMoviesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TypeViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()
    val status : LiveData<String> = _status

    private val _typeMovies = MutableLiveData<Results>()
    val typeMovies : LiveData<Results> = _typeMovies

    fun getTypeMovies(isConnected: Boolean, db : AppDatabase, id: Int){
        viewModelScope.launch (Dispatchers.IO){
            try {
                if(isConnected) {
                    val data = TypeMoviesApi.retrofitService.getTypeMovies(withGenres = id)
                    _typeMovies.postValue(data)

                }
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
                Log.d("TypeViewModel", "${e.message}")
            }
        }
    }
}