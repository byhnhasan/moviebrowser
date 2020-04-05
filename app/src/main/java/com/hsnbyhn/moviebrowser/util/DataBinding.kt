package com.hsnbyhn.moviebrowser.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hsnbyhn.moviebrowser.BuildConfig
import com.hsnbyhn.moviebrowser.data.model.MovieModel
import com.hsnbyhn.moviebrowser.feature.MovieFragmentAdapter
import com.hsnbyhn.moviebrowser.feature.MovieItemListener
import com.hsnbyhn.moviebrowser.feature.moviedetail.MovieGenreRecyclerViewAdapter

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/


const val PORTRAIT_SPAN = 2
const val LANDSCAPE_SPAN = 3

@BindingAdapter("app:data", "app:portrait", "app:listener")
fun bindMainRecyclerView(
    recyclerView: RecyclerView,
    data: ArrayList<MovieModel>?,
    portrait: Boolean,
    listener: MovieItemListener?
) {
    if (portrait) {
        recyclerView.layoutManager = GridLayoutManager(recyclerView.context, PORTRAIT_SPAN)
    } else {
        recyclerView.layoutManager = GridLayoutManager(recyclerView.context, LANDSCAPE_SPAN)
    }

    val adapter = MovieFragmentAdapter(data ?: arrayListOf(), listener)
    recyclerView.adapter = adapter
    adapter.notifyDataSetChanged()
}

@BindingAdapter("app:imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    Glide.with(imageView.context).load(BuildConfig.IMAGE_URL + url).into(imageView)

}

@BindingAdapter("app:dataGenre")
fun setMovieGenre(recyclerView: RecyclerView, data: ArrayList<String>?) {
    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, RecyclerView.HORIZONTAL, false)
    val adapter = MovieGenreRecyclerViewAdapter(data ?: arrayListOf())
    recyclerView.adapter = adapter
    adapter.notifyDataSetChanged()
}
