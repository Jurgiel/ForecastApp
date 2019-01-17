package com.jurgielewicz.forecastapp.ui.MainActivity

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.places.Place
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment
import com.google.android.gms.location.places.ui.PlaceSelectionListener
import com.jurgielewicz.forecastapp.R
import com.jurgielewicz.forecastapp.ui.CurrentWeatherFragment.CurrentWeatherFragment
import com.jurgielewicz.forecastapp.ui.DailyWeatherFragment.DailyWeatherFragment
import com.jurgielewicz.forecastapp.ui.MainActivity.recycler.adapter.SavedPlacesAdapter
import com.jurgielewicz.forecastapp.utils.OnItemClickListener
import com.jurgielewicz.forecastapp.utils.addOnItemClickListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(), MainActivityContract.View {

    private val presenter: MainActivityContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.onViewCreated()
    }


    override fun initView() {
        setUpViewPager()
        pageSelectedListener()
        placeSelectedListener()
        drawerListener()
        setupSavedRecycler()
    }

    override fun setUpViewPager() {
        val pagerAdapter = ViewPagerAdapter(supportFragmentManager)
        pagerAdapter.addFragments(CurrentWeatherFragment(), "NOW")
        pagerAdapter.addFragments(DailyWeatherFragment(), "DAILY")
        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun pageSelectedListener() {
        viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                presenter.handlePageListener()
            }
        })
    }

    override fun viewPagerCurrentItem(): Int = viewPager.currentItem

    override fun placeSelectedListener() {
        val placeAutocompleteFragment = fragmentManager.findFragmentById(R.id.autocomplete_fragment)as? PlaceAutocompleteFragment
        placeAutocompleteFragment?.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(p0: Place?) {
              presenter.setSearched(2)
              presenter.search(com.jurgielewicz.forecastapp.db.Place(p0?.latLng?.latitude, p0?.latLng?.longitude, p0?.name.toString()))
            }

            override fun onError(p0: Status?) {
                Log.d("MainActivityError", p0?.statusMessage)
            }
        })
    }

    override fun showSavedPlaces(list: List<com.jurgielewicz.forecastapp.db.Place>) {
        recyclerView_NavBar.layoutManager = LinearLayoutManager(this)
        recyclerView_NavBar.adapter = SavedPlacesAdapter(list)
    }

    override fun setupSavedRecycler() {
        recyclerView_NavBar.layoutManager = LinearLayoutManager(this)
        recyclerView_NavBar.adapter = null
        recyclerView_NavBar.addOnItemClickListener(object: OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                presenter.itemClicked(position)
            }
        })
    }

    override fun drawerListener() {
        drawer_layout.addDrawerListener(object : DrawerLayout.SimpleDrawerListener() {
            override fun onDrawerOpened(drawerView: View) {
                    presenter.drawerOpened()
            }
        } )
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
