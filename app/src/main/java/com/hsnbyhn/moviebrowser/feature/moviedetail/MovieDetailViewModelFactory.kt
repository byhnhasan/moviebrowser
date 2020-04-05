package com.hsnbyhn.moviebrowser.feature.moviedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hsnbyhn.moviebrowser.data.model.MovieModel

/**
 * Created by hasanbayhan on 29.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

class MovieDetailViewModelFactory(
    private val movie: MovieModel
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieDetailViewModel(movie) as T
    }
}