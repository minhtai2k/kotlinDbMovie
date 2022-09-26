package com.example.moviebasics.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.data.models.GenreDataModel
import com.example.moviebasics.databinding.ItemTypeBinding
//import com.example.moviebasics.model.Genre
//import com.example.moviebasics.model.Genres

class GenreAdapter(private val dataSet: List<GenreDataModel>, val onClick: (GenreDataModel) -> Unit) :
    RecyclerView.Adapter<GenreAdapter.GenreGridAdapterViewHolder>() {

    inner class GenreGridAdapterViewHolder(val binding: ItemTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val textView: TextView = binding.textviewItem
        private val cardView: CardView = binding.cardViewItem
        fun bind(genre: GenreDataModel) {
            textView.text = genre.name
            cardView.setOnClickListener {
                onClick(genre)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreGridAdapterViewHolder {
        return GenreGridAdapterViewHolder(
            ItemTypeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GenreGridAdapterViewHolder, position: Int) {
//        val item = dataSet.genres[position]
        val item = dataSet[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
//        return dataSet.genres.size
        return dataSet.size
    }
}