package com.jurgielewicz.forecastapp.ui.presenter

import android.util.Log
import com.google.android.gms.location.places.Place
import com.jurgielewicz.forecastapp.base.BasePresenter
import com.jurgielewicz.forecastapp.ui.contract.MainActivityContract
import com.jurgielewicz.forecastapp.ui.contract.MainActivityContract.MainActivityView

class MainActivityPresenter(view: MainActivityView): BasePresenter<MainActivityView>(view), MainActivityContract.MainActivityPresenter {
    private val TAG = "MainActivityPresenter"

    override fun onViewCreated() {
        view.initView()
    }

    override fun handlePageListener() {
        when(view.viewPagerCurrentItem()){
            0 -> Log.d(TAG, "0")
            1 -> Log.d(TAG, "1")
        }
    }

    override fun search(p0: Place?) {
        
    }
}