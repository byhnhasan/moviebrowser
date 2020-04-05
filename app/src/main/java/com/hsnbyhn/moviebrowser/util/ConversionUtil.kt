package com.hsnbyhn.moviebrowser.util

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

object ConversionUtil {

    fun stringToListOfInt(data: String?): List<Int> {

        var movieGenreList: ArrayList<Int> = arrayListOf()
        if (!data.isNullOrEmpty()) {

            for (item in data) {
                movieGenreList.add(item.toInt())
            }

        }
        return movieGenreList.toList()
    }

    fun listOfIntToString(data: ArrayList<Int>?): String? {

        var movieGenreString = ""
        if (!data.isNullOrEmpty()) {
            for (item in data!!.iterator()) {
                movieGenreString += item.toString() + DELIMETER
            }
        }
        return movieGenreString
    }
}