package com.hsnbyhn.moviebrowser.licence

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hsnbyhn.moviebrowser.R

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

class LicenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_licence)
        val viewModel = ViewModelProvider(this).get(LicenceViewModel::class.java)
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, LicenceActivity::class.java)
        }
    }
}