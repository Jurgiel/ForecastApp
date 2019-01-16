package com.jurgielewicz.forecastapp.ui.view

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.places.Place
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment
import com.google.android.gms.location.places.ui.PlaceSelectionListener
import com.jurgielewicz.forecastapp.R
import com.jurgielewicz.forecastapp.ui.contract.MainActivityContract
import com.jurgielewicz.forecastapp.ui.view.adapters.ViewPagerAdapter
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
              presenter.search(p0)
            }

            override fun onError(p0: Status?) {
                Log.d("MainActivityError", p0?.statusMessage)
            }
        })
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
