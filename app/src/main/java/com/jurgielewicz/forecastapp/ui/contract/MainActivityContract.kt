package com.jurgielewicz.forecastapp.ui.contract

import com.google.android.gms.location.places.Place
import com.jurgielewicz.forecastapp.base.BasePresenter

interface MainActivityContract {

    interface View {
        fun initView()
        fun setUpViewPager()
        fun pageSelectedListener()
        fun viewPagerCurrentItem(): Int
        fun placeSelectedListener()
    }

    interface Presenter:BasePresenter  {
        fun handlePageListener()
        fun search(p0: Place?)
        fun setSearched(i: Int)
    }
}