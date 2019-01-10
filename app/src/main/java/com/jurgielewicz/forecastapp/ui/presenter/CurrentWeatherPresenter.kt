package com.jurgielewicz.forecastapp.ui.presenter

import android.util.Log
import com.jurgielewicz.forecastapp.RxBus.RxBus
import com.jurgielewicz.forecastapp.RxBus.RxEvent
import com.jurgielewicz.forecastapp.base.BaseFragmentPresenter
import com.jurgielewicz.forecastapp.ui.contract.CurrentWeatherContract
import javax.inject.Inject

class CurrentWeatherPresenter(private val v: CurrentWeatherContract.View):BaseFragmentPresenter(){

    @Inject
    lateinit var bus: RxBus



    override fun onViewCreated() {
        bus.listen(RxEvent.EventShowCurrentWeather::class.java).subscribe {
            v.updateView(it.list, it.p0)
            Log.d("CurrentWeatherPresenter", "323232")
        }
    }
}