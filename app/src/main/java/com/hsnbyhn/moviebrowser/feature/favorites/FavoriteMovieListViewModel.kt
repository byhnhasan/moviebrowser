package com.hsnbyhn.moviebrowser.feature.favorites

import com.hsnbyhn.moviebrowser.util.ConversionUtil
import com.hsnbyhn.moviebrowser.data.model.MovieModel
import com.hsnbyhn.moviebrowser.data.db.DBInstance
import com.hsnbyhn.moviebrowser.feature.BaseMovieListViewModel

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

class FavoriteMovieListViewModel : BaseMovieListViewModel() {

    init {
        val favoriteMovies = DBInstance.movieDB.movieDao().getAll()


        if (favoriteMovies.isNullOrEmpty().not()) {
            val favoriteMovieList = arrayListOf<MovieModel>()
            for (item in favoriteMovies) {
                val movieModel = MovieModel(
                    id = item.movieId.toLong(),
                    title = item.title,
                    voteAverage = item.voteAverage,
                    posterPath = item.posterPath,
                    releaseDate = item.releaseDate,
                    backdropPath = item.backdropPath,
                    overview = item.overview,
                    genreIds = ConversionUtil.stringToListOfInt(item.genreIds),
                    originalTitle = item.originalTitle,
                    originalLanguage = item.originalLanguage
                )
                favoriteMovieList.add(movieModel)
            }
            movieList.value = favoriteMovieList
        }

    }

}