package com.jurgielewicz.forecastapp.base

import com.jurgielewicz.forecastapp.di.compoents.DaggerFragmentPresenterComponent
import com.jurgielewicz.forecastapp.di.modules.RxBusModule
import com.jurgielewicz.forecastapp.ui.presenter.CurrentWeatherPresenter
import com.jurgielewicz.forecastapp.ui.presenter.DailyWeatherPresenter

abstract class BaseFragmentPresenter {

    private val component = DaggerFragmentPresenterComponent
            .builder()
            .rxBusModule(RxBusModule)
            .build()

    init {
        inject()

    }

    open fun onViewCreated(){}
    open fun onViewDestroyed(){}

    private fun inject(){
        // is MainActivityPresenter -> mainActivityComponent.inject(this)
        when(this){
            is CurrentWeatherPresenter -> component.inject(this)
            is DailyWeatherPresenter -> component.inject(this)
        }
    }
}