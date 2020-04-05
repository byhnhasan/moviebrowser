package com.hsnbyhn.moviebrowser

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hsnbyhn.moviebrowser.data.db.DBInstance
import com.hsnbyhn.moviebrowser.data.db.MovieDatabase
import com.hsnbyhn.moviebrowser.databinding.ActivityMainBinding
import com.hsnbyhn.moviebrowser.feature.favorites.FavoriteMovieListActivity
import com.hsnbyhn.moviebrowser.feature.search.MovieSearchActivity
import com.hsnbyhn.moviebrowser.licence.LicenceActivity
import com.hsnbyhn.moviebrowser.settings.SettingsActivity

private const val OFF_SCREEN_PAGE_LIMIT = 4
const val VIEWPAGER_PAGE_INDEX_UPCOMING = 0
const val VIEWPAGER_PAGE_INDEX_NOWPLAYING = 1
const val VIEWPAGER_PAGE_INDEX_POPULAR = 2
const val VIEWPAGER_PAGE_INDEX_TOPRATED = 3
const val SEARCH_QUERY = "searchQuery"

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        DBInstance.movieDB = MovieDatabase.getInstance(this)

        val toolbar = binding.menuToolbar
        setSupportActionBar(toolbar)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }
        supportActionBar?.title = resources.getString(R.string.app_name)

        drawerLayout = binding.mainDrawerLayout
        val navigationView = binding.mainNavigationViewMenu
        navigationView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            when (menuItem.itemId) {
                R.id.nav_favorites -> {
                    startActivity(FavoriteMovieListActivity.newIntent(this))
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_settings -> {
                    startActivity(SettingsActivity.newIntent(this))
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_licence -> {
                    startActivity(LicenceActivity.newIntent(this))
                    drawerLayout.closeDrawers()
                    true
                }
                else -> false
            }
        }
        setupViewPager(binding)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val searchAction: MenuItem = menu!!.findItem(R.id.search_action)
        val searchView = searchAction.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                startActivity(MovieSearchActivity.newIntent(query, this@MainActivity))
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    private fun setupViewPager(binding: ActivityMainBinding) {
        viewPager = binding.mainViewpager
        //val bottomNavigation = binding.mainBottomNavigation
        //bottomNavigation.setOnNavigationItemSelectedListener(onBottomNavigationItemSelectedListener)
        viewPager.offscreenPageLimit = OFF_SCREEN_PAGE_LIMIT
        /*viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                // NO OPS
            }

            override fun onPageSelected(position: Int) {

                bottomNavigation.menu.getItem(position).isChecked = true
            }

            override fun onPageScrollStateChanged(state: Int) {
                // NO OPS
            }
        })*/
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
        binding.activityMainTablayout.setupWithViewPager(viewPager)
    }

    override fun onDestroy() {

        MovieDatabase.destroyInstance()
        super.onDestroy()
    }


    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            return intent
        }
    }
}
