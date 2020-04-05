package com.hsnbyhn.moviebrowser

import android.app.Application
import android.content.Context

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

class MBApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Companion.applicationContext = applicationContext
    }

    companion object {
        lateinit var applicationContext: Context
    }

}