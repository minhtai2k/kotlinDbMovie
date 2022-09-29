package com.example.moviebasics.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.data.utils.Constants.BASE_IMAGE_URL
import com.example.domain.model.ResultDomainModel
import com.example.moviebasics.R
import com.example.moviebasics.databinding.ItemNewMovieBinding

class TypeMoviesAdapter(
    private val dataSet: List<ResultDomainModel>,
    val onClick: (ResultDomainModel) -> Unit
) :
    RecyclerView.Adapter<TypeMoviesAdapter.TypeMoviesAdapterViewHolder>() {

    inner class TypeMoviesAdapterViewHolder(val binding: ItemNewMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val imgView: ImageView = binding.imageviewItem
        private val cardView: CardView = binding.cardViewItem

        fun bind(item: ResultDomainModel) {
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
        val item = dataSet[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}