package com.hsnbyhn.moviebrowser.settings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hsnbyhn.moviebrowser.MainActivity
import com.hsnbyhn.moviebrowser.R

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val viewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)

        viewModel
    }

    /*override fun attachViewModelObservers() {
        viewModel.changeToEnglish.observe(this) {
            LanguageHelper.changeToEnglish(this)
            navigateToMain()
        }
        viewModel.changeToTurkish.observe(this) {
            LanguageHelper.changeToTurkish(this)
            navigateToMain()
        }
    }

    override fun onViewModelCreated() {
        super.onViewModelCreated()
        viewModel.checkLanguage(LanguageHelper.isLanguageTurkish())
    }*/

    private fun navigateToMain() {
        startActivity(MainActivity.newIntent(this))
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SettingsActivity::class.java)
        }
    }

}