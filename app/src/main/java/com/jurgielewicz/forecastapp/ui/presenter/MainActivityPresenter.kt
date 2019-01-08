package com.jurgielewicz.forecastapp.ui.presenter

import com.jurgielewicz.forecastapp.base.BasePresenter
import com.jurgielewicz.forecastapp.ui.contract.MainActivityContract.MainActivityView

class MainActivityPresenter(view: MainActivityView): BasePresenter<MainActivityView>(view) {


    override fun onViewCreated() {
        view.initView()
    }
}