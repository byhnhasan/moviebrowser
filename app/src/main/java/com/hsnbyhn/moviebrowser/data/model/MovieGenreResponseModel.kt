package com.hsnbyhn.moviebrowser.data

import com.google.gson.annotations.SerializedName
import com.hsnbyhn.moviebrowser.data.model.MovieGenreModel

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

data class MovieGenreResponseModel(
    @SerializedName("genres") val movieGenreList : ArrayList<MovieGenreModel>
)