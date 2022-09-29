package com.example.moviebasics.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.data.utils.Constants.BASE_IMAGE_URL
import com.example.domain.model.MovieDetailDomainModel
import com.example.moviebasics.R
import com.example.moviebasics.databinding.FragmentDetailBinding
import com.example.moviebasics.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val viewModel: DetailViewModel by viewModels()
    private lateinit var binding: FragmentDetailBinding

    private val args: DetailFragmentArgs by navArgs()
    private val movieId by lazy { args.movieId }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        viewModel.movieDetail.observe(viewLifecycleOwner) {
            it?.let { it1 -> bindData(it1) }
        }
        viewModel.getMovieDetail(movieId)
        return binding.root
    }

    private fun bindData(item: MovieDetailDomainModel) {
        val listProduction: MutableList<String> = mutableListOf()
        for (data in item.production_companies) {
            listProduction.add(data.name)
        }

        val listCountries: MutableList<String> = mutableListOf()
        for (data in item.production_countries) {
            listCountries.add(data.name)
        }

        binding.apply {
            imageviewMovieDetail.load(BASE_IMAGE_URL + "" + item.poster_path) {
                placeholder(R.drawable.loading_img)
                error(R.drawable.ic_broken_image)
            }
            nameMovieDetail.text = item.title
            taglineMovieDetail.text = item.tagline
            overviewMovieDetail.text = item.overview
            reLeaseDateMovieDetail.text = HtmlCompat.fromHtml(
                getString(R.string.release_date_movie, item.release_date),
                HtmlCompat.FROM_HTML_MODE_LEGACY
            )
            statusMovieDetail.text = HtmlCompat.fromHtml(
                getString(R.string.status_movie, item.status),
                HtmlCompat.FROM_HTML_MODE_LEGACY
            )
            reviewMovieDetail.text = HtmlCompat.fromHtml(
                getString(
                    R.string.review_movie,
                    item.vote_average,
                    item.vote_count
                ), HtmlCompat.FROM_HTML_MODE_LEGACY
            )
            productionMovieDetail.text = HtmlCompat.fromHtml(
                getString(
                    R.string.companies_production,
                    listProduction.joinToString(" | ")
                ), HtmlCompat.FROM_HTML_MODE_LEGACY
            )
            countryMovieDetail.text = HtmlCompat.fromHtml(
                getString(
                    R.string.companies_countries,
                    listCountries.joinToString(" | ")
                ), HtmlCompat.FROM_HTML_MODE_COMPACT
            )
        }
    }
}