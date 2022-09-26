package com.example.moviebasics.ui

import android.os.Bundle
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
import com.example.moviebasics.databinding.FragmentHomeBinding
import com.example.moviebasics.viewmodel.HomeViewModel
import com.example.moviebasics.network.checkForInternet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    //    @Inject ==> Fail
    private val viewModel: HomeViewModel by viewModels()

    //    @Inject ==> Fail
    private lateinit var binding: FragmentHomeBinding

//    init {
//        setUpStatus()
//        setUpGenres()
//        setUpUpcomingMovies()
//        setUpPopularMovies()
//        setUpTopRatedMovies()
//
//        refreshLayout()
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        setUpStatus()
        setUpGenres()
        setUpUpcomingMovies()
        setUpPopularMovies()
        setUpTopRatedMovies()

        refreshLayout()

//        viewModel.getGenresList(
//            checkForInternet(requireContext())
//        )

//        viewModel.getPopularMovies(
//            checkForInternet(requireContext())
//        )

//        viewModel.getUpcomingMovieList(
//            checkForInternet(requireContext())
//        )

//        viewModel.getTopRatedMovies(
//            checkForInternet(requireContext())
//        )


        return binding.root
    }

    private fun refreshLayout() {
        binding.homeSwipeRefreshLayout.setOnRefreshListener {
            if (viewModel.isLoading.value == true) {
                viewModel.getGenresList(
                    checkForInternet(requireContext())
                )
                viewModel.getPopularMovies(
                    checkForInternet(requireContext())
                )
                viewModel.getUpcomingMovieList(
                    checkForInternet(requireContext())
                )
                viewModel.getTopRatedMovies(
                    checkForInternet(requireContext())
                )
                binding.homeSwipeRefreshLayout.isRefreshing = false
            }
//            binding.homeSwipeRefreshLayout.isRefreshing = viewModel.isLoading.value != true
        }
    }

    private fun setUpStatus() {
        viewModel.status.observe(viewLifecycleOwner) { data ->
            Toast.makeText(this.context, data, Toast.LENGTH_LONG).show()
        }
    }

    private fun setUpGenres() {
        viewModel.getGenresList(
            checkForInternet(requireContext())
        )

        viewModel.genres.observe(viewLifecycleOwner) {
            val adapter = GenreAdapter(it) { data ->
                val direction =
                    HomeFragmentDirections.actionHomeFragmentToTypeFragment(
                        data.id
                    )
                findNavController().navigate(direction)
            }
            binding.fragmentContainerViewType.adapter = adapter
        }
    }

    private fun setUpUpcomingMovies() {
        viewModel.getUpcomingMovieList(
            checkForInternet(requireContext())
        )

        viewModel.resultsUpcoming.observe(viewLifecycleOwner) {
            val adapter = UpcomingMovieAdapter(it) { data ->
                val direction =
                    HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                        data.id
                    )
                findNavController().navigate(direction)
            }
            binding.fragmentContainerViewUpcomingMovie.adapter = adapter
        }
    }

    private fun setUpPopularMovies() {
        viewModel.getPopularMovies(
            checkForInternet(requireContext())
        )

        viewModel.popularMovies.observe(viewLifecycleOwner) {
            val adapter = PopularMoviesAdapter(it) { data ->
                val direction =
                    HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                        data.id
                    )
                findNavController().navigate(direction)
            }
//            setUpViewPager()
            binding.viewpagerPopularMovie.adapter = adapter
        }
    }

    private fun setUpTopRatedMovies() {
        viewModel.getTopRatedMovies(
            checkForInternet(requireContext())
        )

        viewModel.topRatedMovies.observe(viewLifecycleOwner) {
            val adapter = TopRatedMoviesAdapter(it) { data ->
                val direction =
                    HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                        data.id
                    )
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