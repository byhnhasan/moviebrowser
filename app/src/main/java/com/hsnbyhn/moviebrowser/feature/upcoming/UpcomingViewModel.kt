package com.hsnbyhn.moviebrowser.feature.upcoming

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

class UpcomingViewModel : BaseMovieListViewModel() {

    var response: MovieModelResponseModel? = null

    init {
        viewModelScope.launch(Dispatchers.Main) {
            response = SafeApiCall.safeApiCall {
                MBRetrofit.api.getUpcomingMovies()
            }
            movieList.value = response?.movies
        }
    }

}