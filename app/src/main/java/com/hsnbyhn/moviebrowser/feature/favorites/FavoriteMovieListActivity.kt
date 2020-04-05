package com.hsnbyhn.moviebrowser.feature.favorites

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hsnbyhn.moviebrowser.R
import com.hsnbyhn.moviebrowser.databinding.ActivityFavoriteMovieListBinding
import com.hsnbyhn.moviebrowser.feature.moviedetail.MovieDetailActivity
import kotlinx.android.synthetic.main.activity_favorite_movie_list.*

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

class FavoriteMovieListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_movie_list)
        val viewModel = ViewModelProvider(this).get(FavoriteMovieListViewModel::class.java)

        val binding: ActivityFavoriteMovieListBinding = DataBindingUtil.setContentView(this, R.layout.activity_favorite_movie_list)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setSupportActionBar(favorite_movie_toolbar)

        viewModel.onItemClick.observe(this, Observer {
            startActivity(MovieDetailActivity.newIntent(it, this))
        })
    }


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, FavoriteMovieListActivity::class.java)
        }
    }

}