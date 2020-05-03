package com.hsnbyhn.moviebrowser.feature.nowplaying

import androidx.lifecycle.viewModelScope
import com.hsnbyhn.moviebrowser.data.MovieModelResponseModel
import com.hsnbyhn.moviebrowser.feature.BaseMovieListViewModel
import com.hsnbyhn.moviebrowser.network.MBRetrofit
import com.hsnbyhn.moviebrowser.network.SafeApiCall
import kotlinx.coroutines.*

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

class NowPlayingViewModel : BaseMovieListViewModel() {

    var response: MovieModelResponseModel? = null

    init {
        viewModelScope.launch(Dispatchers.Main) {
            response = SafeApiCall.safeApiCall {
                MBRetrofit.api.getNowPlayingMovies()
            }
            movieList.value = response?.movies
        }

    }

}