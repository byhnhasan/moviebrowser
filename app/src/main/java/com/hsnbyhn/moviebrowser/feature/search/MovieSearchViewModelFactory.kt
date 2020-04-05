package com.hsnbyhn.moviebrowser.feature.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hsnbyhn.moviebrowser.data.model.MovieModel
import com.hsnbyhn.moviebrowser.feature.moviedetail.MovieDetailViewModel

/**
 * Created by hasanbayhan on 5.04.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

class MovieSearchViewModelFactory(
    private val query: String
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieSearchViewModel(query) as T
    }
}