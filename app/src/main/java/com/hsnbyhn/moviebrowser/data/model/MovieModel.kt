package com.hsnbyhn.moviebrowser.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

@Parcelize
data class MovieModel(
    @SerializedName("id") val id: Long,
    @SerializedName("vote_average") val voteAverage: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("release_date") val releaseDate: String?,
    @SerializedName("backdrop_path") val backdropPath : String?,
    @SerializedName("overview") val overview : String?,
    @SerializedName("genre_ids") val genreIds : List<Int>?,
    @SerializedName("original_title") val originalTitle : String?,
    @SerializedName("original_language") val originalLanguage : String?

) : Parcelable