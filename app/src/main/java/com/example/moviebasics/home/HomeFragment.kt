package com.example.moviebasics.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.moviebasics.R
import com.example.moviebasics.adapter.*
import com.example.moviebasics.databinding.FragmentHomeBinding
import com.example.moviebasics.model.Results

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        return inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

//        binding.homeViewModel = viewModel su dung data variable moi su dung duoc

//        Setup Status
        viewModel.status.observe(viewLifecycleOwner) {
            Toast.makeText(this.context, it, Toast.LENGTH_LONG).show()
        }

//        Genre Class
        viewModel.genres.observe(viewLifecycleOwner) {
            val adapter = GenreAdapter(it) {
                val direction = HomeFragmentDirections.actionHomeFragmentToTypeFragment(it.id)
                findNavController().navigate(direction)
            }
            binding.fragmentContainerViewType.adapter = adapter
        }

//        UpcomingMovie Class
        viewModel.resultsUpcoming.observe(viewLifecycleOwner) {
            val adapter = UpcomingMovieAdapter(it) {
                val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment(it.id)
                findNavController().navigate(direction)
            }
            binding.fragmentContainerViewUpcomingMovie.adapter = adapter
        }
//        findNavController().navigate(R.id.action_homeFragment_to_detailFragment)

//        PopularMovie Class
        viewModel.popularMovies.observe(viewLifecycleOwner) {
            val adapter = PopularMoviesAdapter(it) {
                val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment(it.id)
                findNavController().navigate(direction)
            }
            setUpViewPager()
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

    private fun setUpViewPager() {
        binding.viewpagerPopularMovie.offscreenPageLimit = 3
        binding.viewpagerPopularMovie.clipToPadding = false
        binding.viewpagerPopularMovie.clipChildren = false
    }
}