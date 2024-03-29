package com.example.moviebasics.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.data.utils.Constants.BASE_IMAGE_URL
import com.example.domain.model.ResultDomainModel
import com.example.moviebasics.R
import com.example.moviebasics.databinding.ItemPopularMovieBinding

class PopularMoviesAdapter(
    private val dataSet: List<ResultDomainModel>,
    val onClick: (ResultDomainModel) -> Unit
) :
    RecyclerView.Adapter<PopularMoviesAdapter.PopularMoviesViewHolder>() {

    inner class PopularMoviesViewHolder(val binding: ItemPopularMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val imageView = binding.imageviewItem
        private val textView = binding.textViewMovieNameItem
        fun bind(item: ResultDomainModel) {
            imageView.load(BASE_IMAGE_URL + "" + item.backdrop_path) {
                placeholder(R.drawable.loading_img)
                error(R.drawable.ic_broken_image)
            }
            imageView.setOnClickListener {
                onClick(item)
            }
            textView.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesViewHolder {
        return PopularMoviesViewHolder(
            ItemPopularMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PopularMoviesViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}