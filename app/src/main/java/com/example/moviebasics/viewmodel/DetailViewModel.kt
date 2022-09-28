package com.example.moviebasics.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.db.AppDatabase
import com.example.data.db.model.MovieDetailEntity
import com.example.data.mappers.*
import com.example.data.repo.RemoteRepoImpl
import com.example.domain.model.MovieDetailDomainModel
import com.example.domain.usecases.GetMovieDetailUseCase
import dagger.Binds
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.reflect.InvocationTargetException
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
//    val db: AppDatabase,
//    private val retrofitDetailMovie: RemoteRepoImpl
    private val modelUseCase: GetMovieDetailUseCase
) : ViewModel() {
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _isLoading = MutableLiveData<Boolean>()
//    val isLoading: LiveData<Boolean> = _isLoading

    private val _movieDetail = MutableLiveData<MovieDetailDomainModel>()
    val movieDetail: LiveData<MovieDetailDomainModel> = _movieDetail

//    @Binds
    fun getMovieDetail(movieId: Int) {
//        val movieDetailDao = db.movieDetailDao()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = modelUseCase.execute(movieId)
                _movieDetail.postValue(data)
            } catch (e: Exception) {
                _status.postValue(e.message)
                Log.d("MovieDetailViewModel","${e.message}")
            }
//            try {
//                if (isConnected) {
//                    val data = retrofitDetailMovie.getMovieDetail(id)
//                    _movieDetail.postValue(data)
//                    movieDetailDao.insert(data)
//                    _isLoading.postValue(true)
//                } else {
//                    val data: MovieDetailEntity = movieDetailDao.loadAllByIds(detailMoviesIds = id)
//                    _movieDetail.postValue(data.toMovieDetailDomainModel())
//                    _isLoading.postValue(true)
//                }
//            } catch (e: Exception) {
//                _status.postValue(e.message)
//                Log.d("MovieDetailLog", "${e.message}")
//            } catch (e: InvocationTargetException) {
//                Log.d("Invocation", "${e.message}")
//            }
        }
    }

//    fun MovieDetailDomainModel.toMovieDetailEntity(): MovieDetailEntity {
//        return MovieDetailEntity(
//            adult = adult,
//            backdrop_path = backdrop_path,
//            belongs_to_collection = belongs_to_collection!!.toBeLongToCollectionDomainModel(),
//            budget =  budget,
////            genres = genres.map {
////                GenreDomainModel(id = it.id, name = it.name)
////            }
//            genres = genres.map {
//                it.toListGenreDomainModel()
//            },
//            homepage = homepage,
//            id = id,
//            imdb_id = imdb_id,
//            original_language = original_language,
//            original_title = original_title,
//            overview = overview,
//            popularity = popularity,
//            poster_path = poster_path,
//            production_companies = production_companies.map { it.toProductionCompaniesDomainModel() },
//            production_countries = production_countries.map { it.toProductionCountriesDomainModel() },
//            release_date = release_date,
//            revenue = revenue,
//            runtime = runtime,
//            spoken_languages = spoken_languages.map { it.toSpokenLanguagesDomainModel() },
//            status = status,
//            tagline = tagline,
//            title = title,
//            video = video,
//            vote_average = vote_average,
//            vote_count = vote_count
//
//        )
//    }

//    private fun MovieDetailDataModel.toDetailMovieEntity() = MovEntity(
//        adult,
//        backdrop_path,
//        belongs_to_collection,
//        budget,
//        genres,
//        homepage,
//        id,
//        imdb_id,
//        original_language,
//        original_title,
//        overview,
//        popularity,
//        poster_path,
//        production_companies,
//        production_countries,
//        release_date,
//        revenue,
//        runtime,
//        spoken_languages,
//        status,
//        tagline,
//        title,
//        video,
//        vote_average,
//        vote_count
//    )
//
//    private fun MovieDetailEntity.toMovieDetailDataModule() = MovieDetailDataModel(
//        adult,
//        backdrop_path,
//        belongs_to_collection,
//        budget,
//        genres,
//        homepage,
//        id,
//        imdb_id,
//        original_language,
//        original_title,
//        overview,
//        popularity,
//        poster_path,
//        production_companies,
//        production_countries,
//        release_date,
//        revenue,
//        runtime,
//        spoken_languages,
//        status,
//        tagline,
//        title,
//        video,
//        vote_average,
//        vote_count
//    )
}