package com.hsnbyhn.moviebrowser.feature

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hsnbyhn.moviebrowser.BuildConfig
import com.hsnbyhn.moviebrowser.data.model.MovieModel
import com.hsnbyhn.moviebrowser.databinding.FragmentBaseMovieItemBinding

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

class MovieFragmentAdapter(
    private val movieList: ArrayList<MovieModel> = arrayListOf(),
    private val listener: MovieItemListener?
) : RecyclerView.Adapter<MovieFragmentAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding =
            FragmentBaseMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    inner class MovieViewHolder(
        val binding: FragmentBaseMovieItemBinding,
        val listener: MovieItemListener?
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                listener?.onClickItem(adapterPosition)
            }
        }

        fun bind(movie: MovieModel) {
            binding.movie = movie
            /*Glide.with(binding.movieImageviewPosterImage.context).
                load(BuildConfig.IMAGE_URL + movie.posterPath).into(binding.movieImageviewPosterImage)*/
            binding.executePendingBindings()
        }


    }

}


interface MovieItemListener {
    fun onClickItem(position: Int)
}