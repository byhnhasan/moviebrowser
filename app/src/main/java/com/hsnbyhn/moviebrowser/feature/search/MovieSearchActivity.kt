package com.hsnbyhn.moviebrowser.feature.search

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hsnbyhn.moviebrowser.R
import com.hsnbyhn.moviebrowser.SEARCH_QUERY
import com.hsnbyhn.moviebrowser.databinding.ActivityMovieSearchBinding
import com.hsnbyhn.moviebrowser.feature.moviedetail.MovieDetailActivity

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

class MovieSearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this, MovieSearchViewModelFactory(intent.getStringExtra(SEARCH_QUERY).orEmpty())).get(MovieSearchViewModel::class.java)
        viewModel.setPortrait(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)

        val binding: ActivityMovieSearchBinding = DataBindingUtil.setContentView(this,R.layout.activity_movie_search)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.onItemClick.observe(this, Observer {
            startActivity(MovieDetailActivity.newIntent(it, this))
        })
    }

    companion object {
        fun newIntent(query: String, context: Context): Intent {
            val intent = Intent(context, MovieSearchActivity::class.java)
            intent.putExtra(SEARCH_QUERY, query)
            return intent
        }
    }


}