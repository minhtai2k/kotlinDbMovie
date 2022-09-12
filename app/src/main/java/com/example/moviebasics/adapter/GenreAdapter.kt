package com.example.moviebasics.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviebasics.databinding.ItemTypeBinding
import com.example.moviebasics.model.Genre
import com.example.moviebasics.model.Genres

class GenreAdapter(private val dataSet: Genres, val onClick : (Genre) -> Unit) :
    RecyclerView.Adapter<GenreAdapter.GenreGridAdapterViewHolder>() {

    inner class GenreGridAdapterViewHolder(val binding: ItemTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val textView: TextView = binding.textviewItem
        private val cardView: CardView = binding.cardviewItem
        fun bind(genre: Genre) {
            textView.text = genre.name
            cardView.setOnClickListener {
                onClick(genre)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreGridAdapterViewHolder {
        return GenreGridAdapterViewHolder(ItemTypeBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: GenreGridAdapterViewHolder, position: Int) {
        val item = dataSet.genres[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataSet.genres.size
    }
}