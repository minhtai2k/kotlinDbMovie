package com.example.moviebasics.detailmovie

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.moviebasics.R
import com.example.moviebasics.databinding.FragmentDetailBinding
import com.example.moviebasics.model.MovieDetail
import com.example.moviebasics.network.BASE_IMAGE_URL

class DetailFragment : Fragment() {

    private val viewModel: DetailViewModel by viewModels()
    private lateinit var binding: FragmentDetailBinding

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
        viewModel.movieDetail.observe(viewLifecycleOwner) {
            bindData(it)
        }
        return binding.root
    }

    private fun bindData(item: MovieDetail) {
        binding.imageviewMovieDetail.load(BASE_IMAGE_URL + "" + item.poster_path) {
            placeholder(R.drawable.loading_img)
            error(R.drawable.ic_broken_image)
        }
        binding.nameMovieDetail.text = item.title
        binding.taglineMovieDetail.text = item.tagline
        binding.overviewMovieDetail.text = item.overview

//        binding.releasedateMovieDetail.text = Html.fromHtml(getString(R.string.release_date_movie, item.release_date))
        binding.releasedateMovieDetail.text = HtmlCompat.fromHtml(
            getString(R.string.release_date_movie, item.release_date),
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )
//        binding.statusMovieDetail.text = Html.fromHtml(getString(R.string.status_movie, item.status))
        binding.statusMovieDetail.text = HtmlCompat.fromHtml(
            getString(R.string.status_movie, item.status),
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )
//        binding.reviewMovieDetail.text = Html.fromHtml(getString(R.string.review_movie, item.vote_average, item.vote_count))
        binding.reviewMovieDetail.text = HtmlCompat.fromHtml(
            getString(
                R.string.review_movie,
                item.vote_average,
                item.vote_count
            ), HtmlCompat.FROM_HTML_MODE_LEGACY
        )

        val listProduction: MutableList<String> = mutableListOf()
        for (item in item.production_companies) {
            listProduction.add(item.name)
        }
//        binding.productionMovieDetail.setText(Html.fromHtml(getString(R.string.companies_production, listProduction.joinToString(" | "))))
        binding.productionMovieDetail.text = HtmlCompat.fromHtml(
            getString(
                R.string.companies_production,
                listProduction.joinToString {" | "}
            ), HtmlCompat.FROM_HTML_MODE_LEGACY
        )

        val listCountries: MutableList<String> = mutableListOf()
        for (item in item.production_countries) {
            listCountries.add(item.name)
        }
//        binding.countryMovieDetail.setText(Html.fromHtml(getString(R.string.companies_countries, listCountries.joinToString(" | "))))
        binding.countryMovieDetail.text = HtmlCompat.fromHtml(
            getString(
                R.string.companies_countries,
                listCountries.joinToString {" | "}
            ), HtmlCompat.FROM_HTML_MODE_LEGACY
        )
    }
}