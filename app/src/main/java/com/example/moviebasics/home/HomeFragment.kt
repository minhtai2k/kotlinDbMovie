package com.example.moviebasics.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.moviebasics.adapter.GenreAdapter
import com.example.moviebasics.adapter.PopularMoviesAdapter
import com.example.moviebasics.adapter.TopRatedMoviesAdapter
import com.example.moviebasics.adapter.UpcomingMovieAdapter
import com.example.moviebasics.database.getDatabase
import com.example.moviebasics.databinding.FragmentHomeBinding
import com.example.moviebasics.network.checkForInternet
import dagger.hilt.android.AndroidEntryPoint

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
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        viewModel.getGenresList(
            checkForInternet(requireContext()),
            getDatabase(requireActivity().applicationContext)
        )

        viewModel.getPopularMovies(
            checkForInternet(requireContext()),
            getDatabase(requireActivity().applicationContext)
        )
        viewModel.getUpcomingMovieList(
            checkForInternet(requireContext()),
            getDatabase(requireActivity().applicationContext)
        )
        viewModel.getTopRatedMovies(
            checkForInternet(requireContext()),
            getDatabase(requireActivity().applicationContext)
        )

        setUpStatus()
        setUpGenres()
        setUpUpcomingMovies()
        setUpPopularMovies()
        setUpTopRatedMovies()

        refreshLayout()

        return binding.root
    }

    private fun refreshLayout() {
        binding.homeSwipeRefreshLayout.setOnRefreshListener {
            if (viewModel.isLoading.value == true) {
                viewModel.getGenresList(
                    checkForInternet(requireContext()),
                    getDatabase(requireActivity().applicationContext)
                )
                viewModel.getPopularMovies(
                    checkForInternet(requireContext()),
                    getDatabase(requireActivity().applicationContext)
                )
                binding.homeSwipeRefreshLayout.isRefreshing = false
            }
//            binding.homeSwipeRefreshLayout.isRefreshing = viewModel.isLoading.value != true
        }
    }

    private fun setUpStatus() {
        viewModel.status?.observe(viewLifecycleOwner) {
            Toast.makeText(this.context, it, Toast.LENGTH_LONG).show()
            Log.d("Status", "${it.toString()}")
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

    private fun setUpUpcomingMovies() {
        viewModel.resultsUpcoming.observe(viewLifecycleOwner) {
            val adapter = UpcomingMovieAdapter(it) {
                val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment(it.id)
                findNavController().navigate(direction)
            }
            binding.fragmentContainerViewUpcomingMovie.adapter = adapter
        }
    }

    private fun setUpPopularMovies() {
        viewModel.popularMovies.observe(viewLifecycleOwner) {
            val adapter = PopularMoviesAdapter(it) {
                val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment(it.id)
                findNavController().navigate(direction)
            }
//            setUpViewPager()
            binding.viewpagerPopularMovie.adapter = adapter
        }
    }

    private fun setUpTopRatedMovies() {
        viewModel.topRatedMovies.observe(viewLifecycleOwner) {
            val adapter = TopRatedMoviesAdapter(it) {
                val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment(it.id)
                findNavController().navigate(direction)
            }
            binding.recyclerviewTopRatedMovie.adapter = adapter
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