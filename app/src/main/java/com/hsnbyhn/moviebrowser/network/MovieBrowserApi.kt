package com.hsnbyhn.moviebrowser.network

import com.hsnbyhn.moviebrowser.BuildConfig
import com.hsnbyhn.moviebrowser.data.MovieGenreResponseModel
import com.hsnbyhn.moviebrowser.data.MovieModelResponseModel
import com.hsnbyhn.moviebrowser.languagehelper.LanguageHelper
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/
interface MovieBrowserApi {

    @GET("/movie/now_playing?api_key=${BuildConfig.API_KEY}")
    suspend fun getNowPlayingMovies(@Query("language") language : String = LanguageHelper.currentLanguage): MovieModelResponseModel

    @GET("/movie/popular?api_key=${BuildConfig.API_KEY}")
     suspend fun getPopularMovies(@Query("language") language : String = LanguageHelper.currentLanguage): MovieModelResponseModel

    @GET("/movie/top_rated?api_key=${BuildConfig.API_KEY}")
     suspend fun getTopRatedMovies(@Query("language") language : String = LanguageHelper.currentLanguage): MovieModelResponseModel

    @GET("/movie/upcoming?api_key=${BuildConfig.API_KEY}")
     suspend fun getUpcomingMovies(@Query("language") language : String = LanguageHelper.currentLanguage): MovieModelResponseModel

    @GET("/genre/movie/list?api_key=${BuildConfig.API_KEY}")
     suspend fun getMovieGenreList(@Query("language") language : String = LanguageHelper.currentLanguage): MovieGenreResponseModel

    @GET(value = "/search/movie?api_key=${BuildConfig.API_KEY}")
     suspend fun getMovieSearchList(@Query("query") query: String, @Query("language") language : String = LanguageHelper.currentLanguage) : MovieModelResponseModel
}