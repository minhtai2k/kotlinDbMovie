package com.example.data.repo

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.example.data.db.model.GenreEntity
import com.example.data.mappers.*
import com.example.domain.model.GenreDomainModel
import com.example.domain.model.MovieDetailDomainModel
import com.example.domain.model.ResultDomainModel
import com.example.domain.repositories.RemoteRepo
import kotlinx.coroutines.currentCoroutineContext
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class DataRepository @Inject constructor (
    private val context: Context,
    private val local: LocalRepoImpl,
    private val remote: RemoteRepoImpl
) : RemoteRepo {

    private fun checkForInternet(context: Context): Boolean {

        // register activity with the connectivity manager service
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // if the android version is equal to M
        // or greater we need to use the
        // NetworkCapabilities to check what type of
        // network has the internet connection
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            // Returns a Network object corresponding to
            // the currently active default data network.
            val network = connectivityManager.activeNetwork ?: return false

            // Representation of the capabilities of an active network.
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when {
                // Indicates this network uses a Wi-Fi transport,
                // or WiFi has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true

                // Indicates this network uses a Cellular transport. or
                // Cellular has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                // else return false
                else -> false
            }
        } else {
            // if the android version is below M
            @Suppress("DEPRECATION") val networkInfo =
                connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
    }

    override suspend fun getGenresDetail(): List<GenreDomainModel> {
        return if(checkForInternet(context)) {
            val data = remote.getGenresDetail()
            local.insertAllGenre(data.map { it.toGenreEntity() })
            data
        } else
            local.getGenresDetail()
    }

    override suspend fun getMovieDetail(movieId: Int): MovieDetailDomainModel {
        return if(checkForInternet(context)) {
            val data = remote.getMovieDetail(movieId)
            local.insertMovieDetail(data.toMovieDetailEntity())
            data
        } else
            local.getMovieDetail(movieId)
    }

    override suspend fun getUpComingMoviesDetail(): List<ResultDomainModel> {
        return if(checkForInternet(context)) {
            val data = remote.getUpComingMoviesDetail()
            local.insertAllUpComingMovie(data.map { it.toResultEntity() })
            data
        } else
            local.getUpComingMoviesDetail()
    }

    override suspend fun getPopularMoviesDetail(): List<ResultDomainModel> {
        return if(checkForInternet(context)) {
            val data = remote.getPopularMoviesDetail()
            local.insertAllUpComingMovie(data.map { it.toResultEntity() })
            data
        } else
            local.getUpComingMoviesDetail()
    }

    override suspend fun getGenreMoviesDetail(genreId: Int): List<ResultDomainModel> {
        return if(checkForInternet(context)) {
            val data = remote.getGenreMoviesDetail(genreId)
            local.insertAllUpComingMovie(data.map { it.toResultEntity() })
            data
        } else
            local.getUpComingMoviesDetail()
    }

    override suspend fun getTopRatedMoviesDetail(): List<ResultDomainModel> {
        return if(checkForInternet(context)) {
            val data = remote.getTopRatedMoviesDetail()
            local.insertAllUpComingMovie(data.map { it.toResultEntity() })
            data
        } else
            local.getUpComingMoviesDetail()
    }


}