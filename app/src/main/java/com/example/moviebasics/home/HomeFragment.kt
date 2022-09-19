package com.example.moviebasics.home

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.moviebasics.adapter.GenreAdapter
import com.example.moviebasics.adapter.PopularMoviesAdapter
import com.example.moviebasics.adapter.TopRatedMoviesAdapter
import com.example.moviebasics.adapter.UpcomingMovieAdapter
import com.example.moviebasics.database.AppDatabase
import com.example.moviebasics.database.DATABASE_NAME
import com.example.moviebasics.databinding.FragmentHomeBinding
import com.example.moviebasics.network.GenresApi
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

//    @Inject ==> Fail
    private val viewModel: HomeViewModel by viewModels()

//    @Inject ==> Fail
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        return inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        viewModel.getGenresList(checkForInternet(requireContext()), getDatabase())
        viewModel.getPopularMovies(checkForInternet(requireContext()), getDatabase())

        refreshLayout()

//        viewModel.getTopRatedMovies(db, checkForInternet(requireContext()))
//        binding.homeViewModel = viewModel su dung data variable moi su dung duoc

//        Setup Status
//        viewModel.status?.observe(viewLifecycleOwner) {
//            Toast.makeText(this.context, it, Toast.LENGTH_LONG).show()
//        }
        setUpStatus()

//        Genre Class
//        viewModel.genres.observe(viewLifecycleOwner) {
//             val adapter = GenreAdapter(it) {
//                val direction = HomeFragmentDirections.actionHomeFragmentToTypeFragment(it.id)
//                findNavController().navigate(direction)
//            }
//            binding.fragmentContainerViewType.adapter = adapter
//        }
        setUpGenres()

//        UpcomingMovie Class
        viewModel.resultsUpcoming.observe(viewLifecycleOwner) {
            val adapter = UpcomingMovieAdapter(it) {
                val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment(it.id)
                findNavController().navigate(direction)
            }
            binding.fragmentContainerViewUpcomingMovie.adapter = adapter
        }

//        PopularMovie Class
        viewModel.popularMovies.observe(viewLifecycleOwner) {
            val adapter = PopularMoviesAdapter(it) {
                val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment(it.id)
                findNavController().navigate(direction)
            }
//            setUpViewPager()
            binding.viewpagerPopularMovie.adapter = adapter
        }

//        TopRatedMovie Class
        viewModel.topRatedMovies.observe(viewLifecycleOwner) {
            val adapter = TopRatedMoviesAdapter(it) {
                val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment(it.id)
                findNavController().navigate(direction)
            }
            binding.recyclerviewTopRatedMovie.adapter = adapter
        }
        return binding.root
    }

    private fun getDatabase() : AppDatabase {
        return GenresApi.getDatabase(requireActivity().applicationContext)
    }

    private fun refreshLayout() {
        binding.homeSwipeRefreshLayout.setOnRefreshListener {
//            viewModel.getGenresList(checkForInternet(requireContext()), db)
            if(viewModel.isLoading.value == true) {
                viewModel.getGenresList(checkForInternet(requireContext()), getDatabase())
                viewModel.getPopularMovies(checkForInternet(requireContext()), getDatabase())
                binding.homeSwipeRefreshLayout.isRefreshing = false
            }
//            binding.homeSwipeRefreshLayout.isRefreshing = viewModel.isLoading.value != true
        }
    }

    private fun setUpStatus() {
        viewModel.status?.observe(viewLifecycleOwner) {
            Toast.makeText(this.context, it, Toast.LENGTH_LONG).show()
        }
    }

    private fun setUpGenres() {
        viewModel.genres.observe(viewLifecycleOwner) {
            val adapter = GenreAdapter(it) {
                val direction = HomeFragmentDirections.actionHomeFragmentToTypeFragment(it.id)
                findNavController().navigate(direction)
            }
            binding.fragmentContainerViewType.adapter = adapter
        }
    }

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

//    private val db by lazy {
//        Room.databaseBuilder(
//            requireActivity().applicationContext,
//            AppDatabase::class.java,
//            DATABASE_NAME
//        ).build()
//    }

//    private fun setUpViewPager() {
//        binding.viewpagerPopularMovie.offscreenPageLimit = 3
//        binding.viewpagerPopularMovie.clipToPadding = false
//        binding.viewpagerPopularMovie.clipChildren = false
//    }
}