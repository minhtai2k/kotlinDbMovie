package com.example.moviebasics.detailmovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.moviebasics.R
import com.example.moviebasics.databinding.FragmentDetailBinding
import com.example.moviebasics.model.MovieDetail

class DetailFragment : Fragment() {

    private val viewModel: DetailViewModel by viewModels()
    private lateinit var binding : FragmentDetailBinding

    private val args: DetailFragmentArgs by navArgs()
    private val movieId by lazy { args.movieId }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.fragment_detail, container, false)
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        viewModel.getMovieDetail(movieId)
        viewModel.movieDetail.observe(viewLifecycleOwner){
            bindData(it)
        }
        return binding.root
    }

    private fun bindData(item : MovieDetail){
        binding.nameMovieDetail.text = item.title
        binding.taglineMovieDetail.text = item.tagline
        binding.releasedateMovieDetail.text = item.release_date
        binding.statusMovieDetail.text = item.status
        binding.overviewMovieDetail.text = item.overview
        binding.countryMovieDetail.text = item.production_countries.toString()
        binding.productionMovieDetail.text = item.production_companies.toString()
        binding.reviewMovieDetail.text = item.vote_average.toString()

    }
}