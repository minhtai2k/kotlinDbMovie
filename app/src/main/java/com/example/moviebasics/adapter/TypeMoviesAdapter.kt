package com.example.moviebasics.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.moviebasics.R
import com.example.moviebasics.databinding.ItemNewMovieBinding
import com.example.moviebasics.model.Result
import com.example.moviebasics.model.Results
import com.example.moviebasics.network.BASE_IMAGE_URL

class TypeMoviesAdapter(
    private val dataSet: Results,
    val genreId: Int,
    val onClick: (Result) -> Unit
) :
    RecyclerView.Adapter<TypeMoviesAdapter.TypeMoviesAdapterViewHolder>() {

    inner class TypeMoviesAdapterViewHolder(val binding: ItemNewMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //        private val textView: TextView = binding.textviewItem
        private val imgView: ImageView = binding.imageviewItem
        private val cardView: CardView = binding.cardviewItem

        fun bind(item: Result) {
//            textView.text = item.title
            imgView.load(BASE_IMAGE_URL + "" + item.poster_path) {
                placeholder(R.drawable.loading_img)
                error(R.drawable.ic_broken_image)
            }
            cardView.setOnClickListener {
                onClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeMoviesAdapterViewHolder {
        return TypeMoviesAdapterViewHolder(
            ItemNewMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TypeMoviesAdapterViewHolder, position: Int) {
        val item = dataSet.results[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataSet.results.size
    }
}