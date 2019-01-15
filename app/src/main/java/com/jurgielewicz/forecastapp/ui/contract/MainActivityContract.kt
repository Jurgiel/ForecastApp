package com.jurgielewicz.forecastapp.ui.contract

import com.google.android.gms.location.places.Place

interface MainActivityContract {

    interface View {
        fun initView()
        fun setUpViewPager()
        fun pageSelectedListener()
        fun viewPagerCurrentItem(): Int
        fun placeSelectedListener()
    }

    interface Presenter  {
        fun handlePageListener()
        fun search(p0: Place?)
        fun setSearched(i: Int)
    }
}