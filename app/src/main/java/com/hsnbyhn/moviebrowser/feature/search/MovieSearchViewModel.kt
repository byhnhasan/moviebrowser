package com.hsnbyhn.moviebrowser.feature.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hsnbyhn.moviebrowser.data.MovieModelResponseModel
import com.hsnbyhn.moviebrowser.feature.BaseMovieListViewModel
import com.hsnbyhn.moviebrowser.network.MBRetrofit
import com.hsnbyhn.moviebrowser.network.SafeApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

class MovieSearchViewModel(
    query: String
) : BaseMovieListViewModel() {

    var searchQuery = MutableLiveData<String>()
    var response: MovieModelResponseModel? = null

    init {
        searchQuery.value = query

        viewModelScope.launch(Dispatchers.Main) {
            response = SafeApiCall.safeApiCall {
                MBRetrofit.api.getMovieSearchList(searchQuery.value!!)
            }
            movieList.value = response?.movies
        }
    }
}