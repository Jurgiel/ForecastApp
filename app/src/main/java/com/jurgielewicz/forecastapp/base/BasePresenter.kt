package com.jurgielewicz.forecastapp.base

import com.jurgielewicz.forecastapp.di.compoents.DaggerMainActivityComponent
import com.jurgielewicz.forecastapp.di.modules.DaoModule
import com.jurgielewicz.forecastapp.di.modules.RetrofitModule
import com.jurgielewicz.forecastapp.di.modules.RxBusModule
import com.jurgielewicz.forecastapp.ui.presenter.MainActivityPresenter

abstract class BasePresenter<out V: BaseView>(protected val view: V) {

    private val mainActivityComponent = DaggerMainActivityComponent
            .builder()
            .retrofitModule(RetrofitModule)
            .rxbusModule(RxBusModule)
            .daoModule(DaoModule)
            .baseView(view)
            .build()

    init {
        inject()
    }

    open fun onViewCreated(){}
    open fun onViewDestroyed(){}

    private fun inject(){
        when(this){
            is MainActivityPresenter -> mainActivityComponent.inject(this)
        }
    }
}