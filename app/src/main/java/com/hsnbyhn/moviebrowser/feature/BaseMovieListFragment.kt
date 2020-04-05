package com.hsnbyhn.moviebrowser.feature

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hsnbyhn.moviebrowser.*
import com.hsnbyhn.moviebrowser.databinding.FragmentBaseMovieListBinding
import com.hsnbyhn.moviebrowser.databinding.FragmentBaseMovieListBindingImpl
import com.hsnbyhn.moviebrowser.feature.moviedetail.MovieDetailActivity
import com.hsnbyhn.moviebrowser.feature.nowplaying.NowPlayingViewModel
import com.hsnbyhn.moviebrowser.feature.popular.PopularViewModel
import com.hsnbyhn.moviebrowser.feature.toprated.TopRatedViewModel
import com.hsnbyhn.moviebrowser.feature.upcoming.UpcomingViewModel
import com.hsnbyhn.moviebrowser.util.LANDSCAPE_SPAN
import com.hsnbyhn.moviebrowser.util.PORTRAIT_SPAN
import kotlinx.android.synthetic.main.fragment_base_movie_list.*
import java.lang.IllegalArgumentException

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

const val MOVIE = "movie"

class BaseMovieListFragment : Fragment() {

    private val position by lazy { arguments?.getInt(KEY_POSITION) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val viewModel = ViewModelProvider(this).get(initViewModel()::class.java)
        viewModel.setPortrait(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
        val binding: FragmentBaseMovieListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_base_movie_list, container, false);
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.onItemClick.observe(viewLifecycleOwner, Observer {
            startActivity(MovieDetailActivity.newIntent(it, context!!))
        })
        return binding.root

            /*viewModel.movieList.observe(viewLifecycleOwner, Observer {movies ->
            movie_recycler_view.let {
                if (viewModel.portrait.value == true) {
                    it.layoutManager = GridLayoutManager(it.context, PORTRAIT_SPAN)
                } else {
                    it.layoutManager = GridLayoutManager(it.context, LANDSCAPE_SPAN)
                }
                it.setHasFixedSize(true)
                val adapter = MovieFragmentAdapter(movies, viewModel)
                it.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        })
        return inflater.inflate(R.layout.fragment_base_movie_list, container, false)*/
    }


    private fun initViewModel(): BaseMovieListViewModel {
        return when (position) {
            VIEWPAGER_PAGE_INDEX_UPCOMING -> UpcomingViewModel()
            VIEWPAGER_PAGE_INDEX_NOWPLAYING -> NowPlayingViewModel()
            VIEWPAGER_PAGE_INDEX_POPULAR -> PopularViewModel()
            VIEWPAGER_PAGE_INDEX_TOPRATED -> TopRatedViewModel()
            else -> throw IllegalArgumentException("Unknown position!")
        }
    }


    companion object {
        private const val KEY_POSITION = "KEY_POSITION"
        fun newInstance(position: Int): BaseMovieListFragment =
            BaseMovieListFragment().apply {
                arguments = Bundle().apply {
                    putInt(KEY_POSITION, position)
                }
            }
    }
}