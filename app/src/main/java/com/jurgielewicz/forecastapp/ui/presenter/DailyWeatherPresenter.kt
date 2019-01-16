package com.jurgielewicz.forecastapp.ui.presenter


import com.jurgielewicz.forecastapp.RxBus.RxBus
import com.jurgielewicz.forecastapp.RxBus.RxEvent
import com.jurgielewicz.forecastapp.ui.contract.DailyWeatherContract

class DailyWeatherPresenter(private val v: DailyWeatherContract.View,
                            private val bus: RxBus): DailyWeatherContract.Presenter {


    override fun onViewCreated() {
        bus.listen(RxEvent.EventShowDailyWeather::class.java).subscribe {
            v.updateView(it.list)
        }
    }
}
