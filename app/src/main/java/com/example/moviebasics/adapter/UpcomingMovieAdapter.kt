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

class UpcomingMovieAdapter(
    private val dataSet: List<ResultDomainModel>,
    val onClick: (ResultDomainModel) -> Unit
) :
    RecyclerView.Adapter<UpcomingMovieAdapter.NewMovieAdapterViewHolder>() {

    inner class NewMovieAdapterViewHolder(val binding: ItemNewMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val cardView: CardView = binding.cardViewItem
        private val imgView: ImageView = binding.imageviewItem

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewMovieAdapterViewHolder {
        return NewMovieAdapterViewHolder(
            ItemNewMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewMovieAdapterViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}