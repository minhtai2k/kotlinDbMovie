package com.example.moviebasics.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.moviebasics.R
import com.example.moviebasics.databinding.ItemNewMovieBinding
import com.example.moviebasics.model.Result
import com.example.moviebasics.model.Results
import com.example.moviebasics.network.BASE_IMAGE_URL

class UpcomingMovieAdapter(private val dataSet : Results) :
    RecyclerView.Adapter<UpcomingMovieAdapter.NewMovieAdapterViewHolder>() {

    class NewMovieAdapterViewHolder(private val binding : ItemNewMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        val cardView : CardView = binding.cardviewItem
        val imgView : ImageView = binding.imageviewItem
        val textView : TextView = binding.textviewItem

        fun bind(item : Result){
//            binding.executePendingBindings()
            textView.text = item.title
            imgView.load(BASE_IMAGE_URL+""+item.poster_path) {
                placeholder(R.drawable.loading_img)
                error(R.drawable.ic_broken_image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewMovieAdapterViewHolder {
        return NewMovieAdapterViewHolder(ItemNewMovieBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: NewMovieAdapterViewHolder, position: Int) {
        val item = dataSet.results[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataSet.results.size
    }
}