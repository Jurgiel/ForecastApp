package com.jurgielewicz.forecastapp.ui.contract

import com.jurgielewicz.forecastapp.base.BasePresenter
import com.jurgielewicz.forecastapp.base.BaseView

interface MainActivityContract {

    interface MainActivityView:BaseView {
        fun initView()
        fun setUpViewPager()
        fun pageSelectedListener()
        fun viewPagerCurrentItem(): Int
    }

    interface MainActivityPresenter  {
        fun handlePageListener()
    }
}