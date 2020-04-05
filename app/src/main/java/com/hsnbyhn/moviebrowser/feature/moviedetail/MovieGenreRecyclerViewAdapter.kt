package com.hsnbyhn.moviebrowser.feature.moviedetail

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hsnbyhn.moviebrowser.databinding.MovieGenreItemBinding

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

class MovieGenreRecyclerViewAdapter(
    private val movieGenreList : ArrayList<String> = arrayListOf()
) :  RecyclerView.Adapter<MovieGenreRecyclerViewAdapter.MovieGenreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieGenreViewHolder {
        val binding = MovieGenreItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieGenreViewHolder(binding)
    }

    override fun getItemCount(): Int = movieGenreList.size

    override fun onBindViewHolder(holder: MovieGenreViewHolder, position: Int) {
        holder.movieGenre.text = movieGenreList[position]
    }

    class MovieGenreViewHolder(binding: MovieGenreItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var movieGenre : TextView = binding.movieGenre

    }

}