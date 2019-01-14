package com.jurgielewicz.forecastapp.ui.presenter

import com.jurgielewicz.forecastapp.RxBus.RxBus
import com.jurgielewicz.forecastapp.RxBus.RxEvent
import com.jurgielewicz.forecastapp.base.BaseFragmentPresenter
import com.jurgielewicz.forecastapp.ui.contract.DailyWeatherContract
import javax.inject.Inject

class DailyWeatherPresenter(private val v: DailyWeatherContract.View):BaseFragmentPresenter<DailyWeatherContract.View>(v){

    @Inject
    lateinit var bus: RxBus


    override fun onViewCreated() {
        bus.listen(RxEvent.EventShowDailyWeather::class.java).subscribe {
            v.updateView(it.list)
        }
    }


}