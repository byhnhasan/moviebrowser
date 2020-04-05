package com.hsnbyhn.moviebrowser.feature.toprated

import android.util.Log
import com.hsnbyhn.moviebrowser.data.MovieModelResponseModel
import com.hsnbyhn.moviebrowser.feature.BaseMovieListViewModel
import com.hsnbyhn.moviebrowser.network.MBRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

class TopRatedViewModel  : BaseMovieListViewModel() {

    init {
        MBRetrofit.api.getTopRatedMovies().enqueue(object : Callback<MovieModelResponseModel> {
            override fun onFailure(call: Call<MovieModelResponseModel>, t: Throwable) {
                Log.d("FAIL", t.message.orEmpty())
            }

            override fun onResponse(call: Call<MovieModelResponseModel>, response: Response<MovieModelResponseModel>) {
                movieList.value = response.body()!!.movies
            }
        })
    }

}