package com.example.moviebasics.detailmovie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviebasics.database.AppDatabase
import com.example.moviebasics.database.model.DetailMovieEntity
import com.example.moviebasics.database.model.GenreEntity
import com.example.moviebasics.model.Genre
import com.example.moviebasics.model.MovieDetail
import com.example.moviebasics.model.Results
import com.example.moviebasics.network.MovieDetailApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.reflect.InvocationTargetException

class DetailViewModel : ViewModel() {
    private val _status = MutableLiveData<String>()
    val status : LiveData<String> = _status

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    private val _movieDetail = MutableLiveData<MovieDetail>()
    val movieDetail : LiveData<MovieDetail> = _movieDetail

    fun getMovieDetail(isConnected: Boolean, db: AppDatabase ,id : Int){
        val movieDetailDao = db.detailMovieDao()
        viewModelScope.launch (Dispatchers.IO){
            try {
                if(isConnected) {
                    val data = MovieDetailApi.retrofitService().getMovieDetail(movieId = id)
                    _movieDetail.postValue(data)
                    movieDetailDao.insert(data.toDetailMovieEntity())
                    _isLoading.postValue(true)
                } else {
                    val data : DetailMovieEntity = movieDetailDao.loadAllByIds(detailMoviesIds = id)
                    _movieDetail.postValue(data.toMovieDetail())
                    _isLoading.postValue(true)
                }
            } catch (e: Exception) {
                _status.value = e.message
            } catch (e: InvocationTargetException) {
                Log.d("Invocation","${e.message}")
            }
        }
    }

    private fun MovieDetail.toDetailMovieEntity() = DetailMovieEntity(
        adult, backdrop_path, belongs_to_collection, budget, genres, homepage, id, imdb_id, original_language, original_title, overview, popularity, poster_path, production_companies, production_countries, release_date, revenue, runtime, spoken_languages, status, tagline, title, video, vote_average, vote_count
    )

    private fun DetailMovieEntity.toMovieDetail() = MovieDetail(
        adult, backdrop_path, belongs_to_collection, budget, genres, homepage, id, imdb_id, original_language, original_title, overview, popularity, poster_path, production_companies, production_countries, release_date, revenue, runtime, spoken_languages, status, tagline, title, video, vote_average, vote_count
    )
}