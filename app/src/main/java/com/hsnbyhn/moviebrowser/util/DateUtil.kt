
package com.hsnbyhn.moviebrowser.util

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

const val DELIMETER = '-'
const val DATE_PARTS = 3
const val SEPERATOR = '.'

object DateUtil {
    fun fixDateFormat(date : String?) : String{

        val dateParts = date?.split(DELIMETER)
        if (dateParts?.size == DATE_PARTS) {
            return dateParts[2] + SEPERATOR + dateParts[1] + SEPERATOR + dateParts[0]

        }
        return ""
    }
}