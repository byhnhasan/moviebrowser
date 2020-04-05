

package com.hsnbyhn.moviebrowser.util

import com.hsnbyhn.moviebrowser.data.model.MovieGenreModel


/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

object MovieGenreUtil {

    fun findGenreName(id: Int, genreList: ArrayList<MovieGenreModel>): String {
        for (i in genreList.indices) {
            if (genreList[i].movieGenreId == id) {
                return genreList[i].movieGenreName.orEmpty()
            }

        }
        return ""
    }
}