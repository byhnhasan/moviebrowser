package com.hsnbyhn.moviebrowser.feature.moviedetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hsnbyhn.moviebrowser.data.MovieGenreResponseModel
import com.hsnbyhn.moviebrowser.data.db.DBInstance
import com.hsnbyhn.moviebrowser.data.db.Movie
import com.hsnbyhn.moviebrowser.data.model.MovieModel
import com.hsnbyhn.moviebrowser.feature.BaseMovieListViewModel
import com.hsnbyhn.moviebrowser.network.MBRetrofit
import com.hsnbyhn.moviebrowser.network.SafeApiCall
import com.hsnbyhn.moviebrowser.util.ConversionUtil
import com.hsnbyhn.moviebrowser.util.DateUtil
import com.hsnbyhn.moviebrowser.util.MovieGenreUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

class MovieDetailViewModel(
    val movie: MovieModel
) : BaseMovieListViewModel() {

    var movieGenreList = MutableLiveData<ArrayList<String>>()
    var movieOverview = MutableLiveData<String>()
    var movieReleaseDate = MutableLiveData<String>()
    var moviePosterPath = MutableLiveData<String>()
    var movieBackdropPath = MutableLiveData<String>()
    var movieRating = MutableLiveData<String>()
    var movieTitle = MutableLiveData<String>()

    var movieLanguage = MutableLiveData<String>()

    var response: MovieGenreResponseModel? = null


    init {
        setFields()

        viewModelScope.launch(Dispatchers.Main) {
            response = SafeApiCall.safeApiCall {
                MBRetrofit.api.getMovieGenreList()
            }
            setGenreList()
        }
    }

    private fun setGenreList() {
        val genreList = arrayListOf<String>()
        for (i in movie.genreIds!!.indices) {
            genreList.add(MovieGenreUtil.findGenreName(movie.genreIds[i], response?.movieGenreList))
        }
        movieGenreList.value = genreList
    }

    private fun setFields() {
        movieReleaseDate.value = DateUtil.fixDateFormat(movie.releaseDate)
        moviePosterPath.value = movie.posterPath
        movieBackdropPath.value = movie.backdropPath
        movieOverview.value = movie.overview
        movieRating.value = movie.voteAverage
        movieTitle.value = movie.title
        movieLanguage.value = movie.originalLanguage
    }

    fun insertFavoriteMovie() {
        val movie = Movie(
            movieId = movie.id.toInt(),
            title = movie.title,
            voteAverage = movie.voteAverage,
            posterPath = movie.posterPath,
            releaseDate = movie.releaseDate,
            backdropPath = movie.backdropPath,
            overview = movie.overview,
            genreIds = ConversionUtil.listOfIntToString(movie.genreIds as? ArrayList<Int>),
            originalTitle = movie.originalTitle,
            originalLanguage = movie.originalLanguage

        )

        DBInstance.movieDB.movieDao().insertMovie(movie)

    }
}