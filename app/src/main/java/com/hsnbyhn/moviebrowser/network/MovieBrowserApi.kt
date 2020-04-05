package com.hsnbyhn.moviebrowser.network

import com.hsnbyhn.moviebrowser.BuildConfig
import com.hsnbyhn.moviebrowser.data.MovieGenreResponseModel
import com.hsnbyhn.moviebrowser.data.MovieModelResponseModel
import com.hsnbyhn.moviebrowser.languagehelper.LanguageHelper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/
interface MovieBrowserApi {

    @GET("/movie/now_playing?api_key=${BuildConfig.API_KEY}")
    fun getNowPlayingMovies(@Query("language") language : String = LanguageHelper.currentLanguage): Call<MovieModelResponseModel>

    @GET("/movie/popular?api_key=${BuildConfig.API_KEY}")
    fun getPopularMovies(@Query("language") language : String = LanguageHelper.currentLanguage): Call<MovieModelResponseModel>

    @GET("/movie/top_rated?api_key=${BuildConfig.API_KEY}")
    fun getTopRatedMovies(@Query("language") language : String = LanguageHelper.currentLanguage): Call<MovieModelResponseModel>

    @GET("/movie/upcoming?api_key=${BuildConfig.API_KEY}")
    fun getUpcomingMovies(@Query("language") language : String = LanguageHelper.currentLanguage): Call<MovieModelResponseModel>

    @GET("/genre/movie/list?api_key=${BuildConfig.API_KEY}")
    fun getMovieGenreList(@Query("language") language : String = LanguageHelper.currentLanguage): Call<MovieGenreResponseModel>

    @GET(value = "/search/movie?api_key=${BuildConfig.API_KEY}")
    fun getMovieSearchList(@Query("query") query: String, @Query("language") language : String = LanguageHelper.currentLanguage) : Call<MovieModelResponseModel>
}