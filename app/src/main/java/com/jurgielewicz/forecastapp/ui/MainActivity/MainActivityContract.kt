package com.jurgielewicz.forecastapp.ui.MainActivity

import com.google.android.gms.location.places.Place
import com.jurgielewicz.forecastapp.base.BasePresenter

interface MainActivityContract {

    interface View {
        fun initView()
        fun setUpViewPager()
        fun pageSelectedListener()
        fun viewPagerCurrentItem(): Int
        fun placeSelectedListener()
        fun drawerListener()
        fun setupSavedRecycler()
        fun showSavedPlaces(list: List<com.jurgielewicz.forecastapp.db.Place>)
    }

    interface Presenter:BasePresenter  {
        fun handlePageListener()
        fun searchClicked(p0: Place?)
        fun search(place: com.jurgielewicz.forecastapp.db.Place?)
        fun setSearched(i: Int)
        fun drawerOpened()
        fun itemClicked(position: Int)
    }
}