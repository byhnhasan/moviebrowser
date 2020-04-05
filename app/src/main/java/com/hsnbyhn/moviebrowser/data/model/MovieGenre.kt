package com.hsnbyhn.moviebrowser.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

data class MovieGenreModel(
    @SerializedName("id") val movieGenreId : Int,
    @SerializedName("name") val movieGenreName : String? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(movieGenreId)
        parcel.writeString(movieGenreName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieGenreModel> {
        override fun createFromParcel(parcel: Parcel): MovieGenreModel {
            return MovieGenreModel(parcel)
        }

        override fun newArray(size: Int): Array<MovieGenreModel?> {
            return arrayOfNulls(size)
        }
    }
}