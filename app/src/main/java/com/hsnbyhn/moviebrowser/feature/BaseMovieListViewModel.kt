package com.hsnbyhn.moviebrowser.feature

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hsnbyhn.moviebrowser.data.model.MovieModel

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

abstract class BaseMovieListViewModel : ViewModel(), MovieItemListener {


    val onItemClick = MutableLiveData<MovieModel>()

    val movieList = MutableLiveData<ArrayList<MovieModel>>()

    val portrait = MutableLiveData<Boolean>()

    override fun onClickItem(position: Int) {
        onItemClick.value = movieList.value!![position]
    }

    fun setPortrait(orientation: Boolean) {
        portrait.value = orientation

    }
}