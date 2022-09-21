package com.example.moviebasics.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.moviebasics.R
import com.example.moviebasics.databinding.ItemNewMovieBinding
import com.example.moviebasics.model.Result
import com.example.moviebasics.model.Results
import com.example.moviebasics.network.BASE_IMAGE_URL

class TopRatedMoviesAdapter(private val dataSet: Results, val onClick: (Result) -> Unit) :
    RecyclerView.Adapter<TopRatedMoviesAdapter.TopRatedMoviesViewHolder>() {

    inner class TopRatedMoviesViewHolder(val binding: ItemNewMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val imageView = binding.imageviewItem
        private val cardView = binding.cardviewItem
        fun bind(item: Result) {
            imageView.load(BASE_IMAGE_URL + "" + item.poster_path) {
                placeholder(R.drawable.loading_img)
                error(R.drawable.ic_broken_image)
            }
            cardView.setOnClickListener {
                onClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedMoviesViewHolder {
        return TopRatedMoviesViewHolder(
            ItemNewMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TopRatedMoviesViewHolder, position: Int) {
        val item = dataSet.results[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataSet.results.size
    }
}