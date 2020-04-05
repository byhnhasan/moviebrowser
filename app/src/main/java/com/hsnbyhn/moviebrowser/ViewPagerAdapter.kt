package com.hsnbyhn.moviebrowser

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.hsnbyhn.moviebrowser.feature.BaseMovieListFragment
import com.hsnbyhn.moviebrowser.feature.nowplaying.NowPlayingViewModel
import com.hsnbyhn.moviebrowser.feature.popular.PopularViewModel
import com.hsnbyhn.moviebrowser.feature.toprated.TopRatedViewModel
import com.hsnbyhn.moviebrowser.feature.upcoming.UpcomingViewModel

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

const val NUMBER_OF_FRAGMENTS = 4

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int) = BaseMovieListFragment.newInstance(position)

    override fun getCount() = NUMBER_OF_FRAGMENTS

    override fun getPageTitle(position: Int): CharSequence? {
       return  when(position) {
            VIEWPAGER_PAGE_INDEX_UPCOMING -> "Upcoming"
            VIEWPAGER_PAGE_INDEX_NOWPLAYING -> "Now Playing"
            VIEWPAGER_PAGE_INDEX_POPULAR -> "Popular"
            VIEWPAGER_PAGE_INDEX_TOPRATED -> "Top Rated"
           else -> "null"
        }
    }
}