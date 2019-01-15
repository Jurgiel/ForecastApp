package com.jurgielewicz.forecastapp.base

import com.jurgielewicz.forecastapp.ui.presenter.MainActivityPresenter

abstract class BasePresenter {



    open fun onViewCreated(){}
    open fun onViewDestroyed(){}

}