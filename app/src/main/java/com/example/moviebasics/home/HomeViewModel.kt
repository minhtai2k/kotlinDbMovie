package com.example.moviebasics.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviebasics.database.AppDatabase
import com.example.moviebasics.database.model.GenreEntity
import com.example.moviebasics.database.model.PopularMovieEntity
import com.example.moviebasics.database.model.TopRatedMovieEntity
import com.example.moviebasics.database.model.UpcomingMovieEntity
import com.example.moviebasics.model.Genre
import com.example.moviebasics.model.Genres
import com.example.moviebasics.model.Result
import com.example.moviebasics.model.Results
import com.example.moviebasics.network.GenresApi
import com.example.moviebasics.network.PopularMovieApi
import com.example.moviebasics.network.TopRatedMovieApi
import com.example.moviebasics.network.UpcomingMovieApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.lang.reflect.InvocationTargetException

class HomeViewModel() : ViewModel() {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _genres = MutableLiveData<Genres>()
    val genres: LiveData<Genres> = _genres

    private val _resultsUpcoming = MutableLiveData<Results>()
    val resultsUpcoming: LiveData<Results> = _resultsUpcoming

    private val _popularMovies = MutableLiveData<Results>()
    val popularMovies: LiveData<Results> = _popularMovies

    private val _topRatedMovies = MutableLiveData<Results>()
    val topRatedMovies: LiveData<Results> = _topRatedMovies

    fun getGenresList(isConnected: Boolean, db: AppDatabase) {
        val genreDao = db.genreDao()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (isConnected) {
//                _status.value = "Load data success"
//                _genres.value = GenresApi.retrofitService.getGenres()
                    val data = GenresApi.retrofitService().getGenres()
                    _genres.postValue(data)
                    genreDao.insertAll(
                        data.genres.map {
                            it.toGenreEntity()
                        })
                    _isLoading.postValue(true)
                    Log.d("Connect Genres Status", "isConnected")
                } else {
//                    Use LiveData
//                    val genreList: List<Genre> = genreDao.getAll().map { it.toGenre() }
//                    _genres.postValue(Genres(genreList))
//                    collect van su dung dc

//                    Use Flow
                    genreDao.getAll().collectLatest {
                        _genres.postValue(Genres(it.map { genre -> genre.toGenre() }))
                    }
                    _isLoading.postValue(true)
                    Log.d("Connect Genres Status", "!isConnected")
                }
            } catch (e: Exception) {
                _status.postValue("Genre Status: ${e.message}")
                Log.d("Genre Status E", "${e.message}")
            }
        }
    }

    fun getUpcomingMovieList(isConnected: Boolean, db: AppDatabase) {
        val upComingMovieDao = db.upcomingMovieDao()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if(isConnected) {
                    val data = UpcomingMovieApi.retrofitService().getUpcomingMovies()
                    _resultsUpcoming.postValue(data)
                    upComingMovieDao.insertAll(
                        data.results.map {
                            it.toUpcomingMovieEntity()
                        }
                    )
                    _isLoading.postValue(true)
                }
                else {
                    val upComingMovieList : List<Result> = upComingMovieDao.getAll().map {
                        it.toResult()
                    }
                    _popularMovies.postValue(Results(upComingMovieList))
                    _isLoading.postValue(true)
                }

            } catch (e: Exception) {
//                _status.value = "Failure: ${e.message}" ==> se bi crash ra khoi app su dung postValue
                _status.postValue("Failure: ${e.message}")
                Log.d("UpcomingMovieList", "${e.message}")
            } catch (e: InvocationTargetException) {
                Log.d("Invocation","${e.message}")
            }
        }
    }

    fun getPopularMovies(isConnected: Boolean, db: AppDatabase) {
        val popularMovieDao = db.popularMovieDao()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (isConnected) {
//                _popularMovies.value = PopularMovieApi.retrofitService.getPopularMovies()
                    val data = PopularMovieApi.retrofitService().getPopularMovies()
                    _popularMovies.postValue(data)
                    popularMovieDao.insertAll(
                        data.results.map {
                            it.toPopularMovieEntity()
                        })
                    _isLoading.postValue(true)
                } else {
                    val popularMovieList: List<Result> = popularMovieDao.getAll().map {
                        it.toResult()
                    }
                    _popularMovies.postValue(Results(popularMovieList))
                    _isLoading.postValue(true)
                }
            } catch (e: Exception) {
//                _status.value = "Failure: ${e.message}"
                _status.postValue("Failure: ${e.message}")
                Log.d("PopularMoviesStatusE", "${e.message}")
            } catch (e: InvocationTargetException) {
                Log.d("Invocation","${e.message}")
            }
        }
    }

    fun getTopRatedMovies(isConnected: Boolean, db: AppDatabase) {
        val topRatedMovieDao = db.topRatedMovieDao()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if(isConnected) {
                    val data = TopRatedMovieApi.retrofitService().getTopRatedMovies()
                    _topRatedMovies.postValue(data)
                    topRatedMovieDao.insertAll(
                        data.results.map {
                            it.toTopRatedEntity()
                        }
                    )
                    _isLoading.postValue(true)
                } else {
                    val topRatedMovieList : List<Result> = topRatedMovieDao.getAll().map {
                        it.toResult()
                    }
                    _topRatedMovies.postValue(Results(topRatedMovieList))
                    _isLoading.postValue(true)
                }
            } catch (e: Exception) {
//                _status.value = "Failure: ${e.message}"
                _status.postValue("Failure: ${e.message}")
                Log.d("TopRatedMovie", "${e.message}")
            } catch (e: InvocationTargetException) {
                Log.d("Invocation","${e.message}")
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

    private fun Result.toUpcomingMovieEntity() = UpcomingMovieEntity(
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

    private fun UpcomingMovieEntity.toResult() = Result(
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

    private fun Result.toTopRatedEntity() = TopRatedMovieEntity(
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

    private fun TopRatedMovieEntity.toResult() = Result(
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
