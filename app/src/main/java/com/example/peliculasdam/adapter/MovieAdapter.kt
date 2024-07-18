package com.example.peliculasdam.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.peliculasdam.data.Movie
import com.example.peliculasdam.databinding.ItemMovieBinding
import com.squareup.picasso.Picasso

class MovieAdapter (
    private var dataSet: List<Movie> = emptyList(),
    private val onItemClickListener: (Int) -> Unit
) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context))
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.render(dataSet[position])
        holder.itemView.setOnClickListener {
            onItemClickListener(position)
        }
    }

    fun updateData(dataSet: List<Movie>) {
        this.dataSet = dataSet
        notifyDataSetChanged()
    }
}

class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    fun render(movie: Movie) {
        binding.titleTextView.text = movie.Title
        binding.yearTextView.text = movie.Year
        Picasso.get().load(movie.Poster).into(binding.posterImageView)

    }
}