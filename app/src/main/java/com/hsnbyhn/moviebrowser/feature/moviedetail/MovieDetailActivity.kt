package com.hsnbyhn.moviebrowser.feature.moviedetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hsnbyhn.moviebrowser.BR
import com.hsnbyhn.moviebrowser.BuildConfig
import com.hsnbyhn.moviebrowser.R
import com.hsnbyhn.moviebrowser.data.model.MovieModel
import com.hsnbyhn.moviebrowser.databinding.ActivityMovieDetailBinding
import com.hsnbyhn.moviebrowser.feature.MOVIE
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.fragment_base_movie_item.*

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

class MovieDetailActivity : AppCompatActivity() {

    lateinit var viewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            MovieDetailViewModelFactory(intent.getParcelableExtra(MOVIE)!!)
        ).get(MovieDetailViewModel::class.java)

        val binding: ActivityMovieDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setSupportActionBar(movie_detail_toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_movie_detail_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item!!.itemId) {
            R.id.action_favorite -> {
                viewModel.insertFavoriteMovie()
                Toast.makeText(this, getString(R.string.add_favorite_message), Toast.LENGTH_SHORT)
                    .show()

                return true
            }

            R.id.action_share -> {
                val text = viewModel.movie.title
                val mimeType = "text/plain"
                ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle(text)
                    .setText(text)
                    .startChooser()
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        fun newIntent(movie: MovieModel, context: Context): Intent {
            var intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(MOVIE, movie)
            return intent
        }
    }

}