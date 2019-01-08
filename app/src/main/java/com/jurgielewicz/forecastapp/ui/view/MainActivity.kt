package com.jurgielewicz.forecastapp.ui.view

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v4.view.PagerAdapter
import android.support.v7.app.AppCompatActivity
import com.jurgielewicz.forecastapp.R
import com.jurgielewicz.forecastapp.base.BaseActivity
import com.jurgielewicz.forecastapp.ui.contract.MainActivityContract
import com.jurgielewicz.forecastapp.ui.presenter.MainActivityPresenter
import com.jurgielewicz.forecastapp.ui.view.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : BaseActivity<MainActivityPresenter>(), MainActivityContract.MainActivityView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        instantiatePresenter()
        presenter.onViewCreated()
    }

    override fun instantiatePresenter(): MainActivityPresenter {
        return MainActivityPresenter(this)
    }

    override fun initView() {
        val pagerAdapter = ViewPagerAdapter(supportFragmentManager)
        pagerAdapter.addFragments(CurrentWeatherFragment(), "NOW")
        pagerAdapter.addFragments(DailyWeatherFragment(), "DAILY")
        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
