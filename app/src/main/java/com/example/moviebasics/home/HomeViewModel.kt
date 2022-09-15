package com.example.moviebasics.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.TypeConverter
import com.example.moviebasics.dao.AppDatabase
import com.example.moviebasics.dao.GenreEntity
import com.example.moviebasics.dao.PopularMovieEntity
import com.example.moviebasics.model.Genre
import com.example.moviebasics.model.Genres
import com.example.moviebasics.model.Result
import com.example.moviebasics.model.Results
import com.example.moviebasics.network.GenresApi
import com.example.moviebasics.network.PopularMovieApi
import com.example.moviebasics.network.TopRatedMovieApi
import com.example.moviebasics.network.UpcomingMovieApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    private val _genres = MutableLiveData<Genres>()
    val genres: LiveData<Genres> = _genres

    private val _resultsUpcoming = MutableLiveData<Results>()
    val resultsUpcoming: LiveData<Results> = _resultsUpcoming

    private val _popularMovies = MutableLiveData<Results>()
    val popularMovies: LiveData<Results> = _popularMovies

    private val _topRatedMovies = MutableLiveData<Results>()
    val topRatedMovies: LiveData<Results> = _topRatedMovies

    init {
//        getGenresList()
        getUpcomingMovieList()
//        getPopularMovies()
        getTopRatedMovies()
    }

    fun getGenresList(isConnected: Boolean, db: AppDatabase) {
        val genreDao = db.genreDao()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (isConnected) {
//                _status.value = "Load data success"
//                _genres.value = GenresApi.retrofitService.getGenres()
                    val data = GenresApi.retrofitService.getGenres()
                    _genres.postValue(data)
                    genreDao.insertAll(
                        data.genres.map {
                            it.toGenreEntity()
                        })
                    _isLoading.postValue(true)
                    Log.d("Connect Genres Status", "isConnected")
                } else {
                    val genreList: List<Genre> = genreDao.getAll().map { it.toGenre() }
                    _genres.postValue(Genres(genreList))
                    _isLoading.postValue(true)
                    Log.d("Connect Genres Status", "!isConnected")
                }
            } catch (e: Exception) {
                _status.postValue("Genre Status: ${e.message}")
                Log.d("Genre Status E", "${e.message}")
            }
        }
    }

    private fun getUpcomingMovieList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
//                _resultsUpcoming.value = UpcomingMovieApi.retrofitService.getUpcomingMovies()
                _resultsUpcoming.postValue(UpcomingMovieApi.retrofitService.getUpcomingMovies())
            } catch (e: Exception) {
//                _status.value = "Failure: ${e.message}" ==> se bi crash ra khoi app su dung postValue
                _status.postValue("Failure: ${e.message}")
                Log.d("UpcomingMovieList", "${e.message}")
            }
        }
    }

    fun getPopularMovies(isConnected: Boolean, db: AppDatabase) {
        val popularMovieDao = db.popularMovieDao()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if(isConnected) {
//                _popularMovies.value = PopularMovieApi.retrofitService.getPopularMovies()
                    val data = PopularMovieApi.retrofitService.getPopularMovies()
                    _popularMovies.postValue(data)
                    popularMovieDao.insertAll(
                        data.results.map {
                            it.toPopularMovieEntity()
                        })
                    _isLoading.postValue(true)
                } else {
                    val popularMovieList : List<Result> = popularMovieDao.getAll().map {
                        it.toResult()
                    }
                    _popularMovies.postValue(Results(popularMovieList))
                    _isLoading.postValue(true)
                }
            } catch (e: Exception) {
//                _status.value = "Failure: ${e.message}"
                _status.postValue("Failure: ${e.message}")
                Log.d("PopularMoviesStatusE", "${e.message}")
            }
        }
    }

    private fun getTopRatedMovies() {
        viewModelScope.launch {
            try {
                _topRatedMovies.postValue(TopRatedMovieApi.retrofitService.getTopRatedMovies())
            } catch (e: Exception) {
//                _status.value = "Failure: ${e.message}"
                _status.postValue("Failure: ${e.message}")
            }
        }
    }

    private fun Genre.toGenreEntity() = GenreEntity(
        gid = id,
        name = name
    )

    private fun GenreEntity.toGenre() = Genre(
        id = gid,
        name = name
    )

    private fun Result.toPopularMovieEntity() = PopularMovieEntity(
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

    private fun PopularMovieEntity.toResult() = Result(
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