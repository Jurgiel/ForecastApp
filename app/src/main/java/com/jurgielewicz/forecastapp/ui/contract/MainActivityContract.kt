package com.jurgielewicz.forecastapp.ui.contract

import com.google.android.gms.location.places.Place
import com.jurgielewicz.forecastapp.base.BasePresenter
import com.jurgielewicz.forecastapp.base.BaseView

interface MainActivityContract {

    interface MainActivityView:BaseView {
        fun initView()
        fun setUpViewPager()
        fun pageSelectedListener()
        fun viewPagerCurrentItem(): Int
        fun placeSelectedListener()
    }

    interface MainActivityPresenter  {
        fun handlePageListener()
        fun search(p0: Place?)
    }
}