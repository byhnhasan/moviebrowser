package com.hsnbyhn.moviebrowser.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

@Entity
data class Movie(
    @PrimaryKey var movieId : Int,
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "vote_average") var voteAverage : String?,
    @ColumnInfo(name = "poster_path") var posterPath : String?,
    @ColumnInfo(name = "release_date") var releaseDate: String?,
    @ColumnInfo(name = "backdrop_path") var backdropPath: String?,
    @ColumnInfo(name = "overview") var overview: String?,
    @ColumnInfo(name = "genre_ids") var genreIds: String?,
    @ColumnInfo(name = "original_title") var originalTitle: String?,
    @ColumnInfo(name = "original_language") var originalLanguage: String?
)