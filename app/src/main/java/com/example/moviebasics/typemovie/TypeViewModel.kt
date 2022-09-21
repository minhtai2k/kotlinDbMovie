package com.example.moviebasics.typemovie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviebasics.database.AppDatabase
import com.example.moviebasics.database.model.TypeMovieEntity
import com.example.moviebasics.model.Result
import com.example.moviebasics.model.Results
import com.example.moviebasics.network.TypeMoviesApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.reflect.InvocationTargetException
import javax.inject.Inject

@HiltViewModel
class TypeViewModel @Inject constructor(
    val db: AppDatabase,
    private val retrofitTypeMovie: TypeMoviesApiService
    ) : ViewModel() {

    private val _status = MutableLiveData<String>()
    val status : LiveData<String> = _status

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _typeMovies = MutableLiveData<Results>()
    val typeMovies : LiveData<Results> = _typeMovies

    fun getTypeMovies(isConnected: Boolean, id: Int){
        val typeMovieDao = db.typeMovieDao()
        viewModelScope.launch (Dispatchers.IO){
            try {
                if(isConnected) {
                    val data = retrofitTypeMovie.getTypeMovies(withGenres = id)
                    _typeMovies.postValue(data)
                    typeMovieDao.insertAll(
                        data.results.map { 
                            it.toTypeMovieEntity()
                        }
                    )
                    _isLoading.postValue(true)
                } else {
                    val data : List<Result> = typeMovieDao.getAll().map {
                        it.toResult()
                    }
                    _typeMovies.postValue(Results(data))
                    _isLoading.postValue(true)
                }
            } catch (e: Exception) {
                _status.postValue(e.message)
                Log.d("TypeViewModel", "${e.message}")
            } catch (e: InvocationTargetException) {
                Log.d("Invocation","${e.message}")
            }
        }
    }

    private fun Result.toTypeMovieEntity() = TypeMovieEntity(
        adult = adult,
        backdrop_path = backdrop_path,
        genre_ids = genre_ids,
        pid = id,
        original_language = original_language,
        original_title = original_title,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        release_date = release_date,
        title = title,
        video = video,
        vote_average = vote_average,
        vote_count = vote_count
    )

    private fun TypeMovieEntity.toResult() = Result(
        adult = adult,
        backdrop_path = backdrop_path,
        genre_ids = genre_ids,
        id = pid,
        original_language = original_language,
        original_title = original_title,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        release_date = release_date,
        title = title,
        video = video,
        vote_average = vote_average,
        vote_count = vote_count
    )
}