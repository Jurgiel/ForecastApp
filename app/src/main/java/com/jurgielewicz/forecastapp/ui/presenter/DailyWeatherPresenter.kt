package com.jurgielewicz.forecastapp.ui.presenter


import com.jurgielewicz.forecastapp.RxBus.RxBus
import com.jurgielewicz.forecastapp.base.BasePresenter
import com.jurgielewicz.forecastapp.ui.contract.DailyWeatherContract

class DailyWeatherPresenter(private val v: DailyWeatherContract.View,
                            private val bus: RxBus):BasePresenter(), DailyWeatherContract.Presenter{

//    @Inject
//    lateinit var bus: RxBus


    override fun onViewCreated() {
//        bus.listen(RxEvent.EventShowDailyWeather::class.java).subscribe {
//            v.updateView(it.list)
        }
    }
