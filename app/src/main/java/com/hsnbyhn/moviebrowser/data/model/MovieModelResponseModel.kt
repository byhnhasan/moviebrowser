package com.hsnbyhn.moviebrowser.data

import com.google.gson.annotations.SerializedName
import com.hsnbyhn.moviebrowser.data.model.MovieModel

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

data class MovieModelResponseModel(
    @SerializedName("results") val movies: ArrayList<MovieModel>
)