package com.example.data.repo

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.example.data.db.model.GenreEntity
import com.example.data.mappers.*
import com.example.domain.model.*
//import com.example.domain.model.GenreListDomainModel
import com.example.domain.repositories.RemoteRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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

    //After Fix
    override suspend fun getGenresListDetail(): GenreListDomainModel {
        return if(checkForInternet(context)) {
            val data = remote.getGenresListDetail()
            local.insertAllGenre(data.genres.map { it.toGenreEntity() })
            data
        } else
            local.getGenresListDetail()
    }

    override suspend fun getPopularMoviesDetail(): ResultsDomainModel {
        return if(checkForInternet(context)) {
            val data = remote.getPopularMoviesDetail()
            local.insertAllPopularMovie(data.results.map { it.toPopularMovieEntity() })
            data
        } else
            local.getPopularMoviesDetail()
    }

//    Use DataModel instead of DomainModel
    override suspend fun getUpComingMoviesDetail(): ResultsDomainModel {
        return if(checkForInternet(context)) {
            val data = remote.getUpComingMoviesDetail()
            local.insertAllUpComingMovie(data.results.map { it.toUpcomingMovieEntity()})
            data
        } else
            local.getUpComingMoviesDetail()
    }

//    Use List instead of Results
    override suspend fun getTopRatedMoviesDetail(): List<ResultDomainModel> {
        return if(checkForInternet(context)) {
            val data = remote.getTopRatedMoviesDetail()
            local.insertAllTopRatedMovies(data.map { it.toTopRatedMovieEntity() })
            data
        } else
            local.getTopRatedMoviesDetail().map { it.toResultDomainModel() }
    }

    override suspend fun getGenreMoviesDetail(genreId: Int): List<ResultDomainModel> {
        return if(checkForInternet(context)) {
            val data = remote.getGenreMoviesDetail(genreId)
            local.insertAllGenreMovies(data.map { it.toGenreMovieEntity() })
            data
        } else
            local.getGenreMoviesDetail(genreId)
    }
}