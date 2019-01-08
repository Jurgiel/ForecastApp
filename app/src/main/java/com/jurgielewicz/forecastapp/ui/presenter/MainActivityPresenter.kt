package com.jurgielewicz.forecastapp.ui.presenter

import com.jurgielewicz.forecastapp.base.BasePresenter
import com.jurgielewicz.forecastapp.ui.contract.MainActivityContract.MainActivityView

class MainActivityPresenter(mainActivityView: MainActivityView): BasePresenter<MainActivityView>(mainActivityView)