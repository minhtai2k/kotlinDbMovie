package com.example.moviebasics.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.moviebasics.R
import com.example.moviebasics.databinding.ItemPopularMovieBinding
import com.example.moviebasics.model.Result
import com.example.moviebasics.model.Results
import com.example.moviebasics.network.BASE_IMAGE_URL

class PopularMoviesAdapter(private val dataSet: Results, val onClick: (Result) -> Unit) :
    RecyclerView.Adapter<PopularMoviesAdapter.PopularMoviesViewHolder>() {

    inner class PopularMoviesViewHolder(val binding: ItemPopularMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val imageView = binding.imageviewItem
        private val textView = binding.textViewMovieNameItem
        fun bind(item: Result) {
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
        val item = dataSet.results[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return dataSet.results.size
    }
}