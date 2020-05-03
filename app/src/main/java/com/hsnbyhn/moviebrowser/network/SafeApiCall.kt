package com.hsnbyhn.moviebrowser.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.lang.IllegalArgumentException

/**
 * Created by hasanbayhan on 2.05.2020
 **/

object SafeApiCall {

    suspend fun <T> safeApiCall(call: suspend () -> T): T? {
        return try {
            withContext(Dispatchers.IO) {
                call.invoke()
            }
        } catch (e: Exception) {
            throw IllegalArgumentException(e.localizedMessage)
        }
    }
}