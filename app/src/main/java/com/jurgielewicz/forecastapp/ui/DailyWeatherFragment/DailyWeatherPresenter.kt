package com.jurgielewicz.forecastapp.ui.DailyWeatherFragment


import com.jurgielewicz.forecastapp.RxBus.RxBus
import com.jurgielewicz.forecastapp.RxBus.RxEvent

class DailyWeatherPresenter(private val v: DailyWeatherContract.View,
                            private val bus: RxBus): DailyWeatherContract.Presenter {


    override fun onViewCreated() {
        bus.listen(RxEvent.EventShowDailyWeather::class.java).subscribe {
            v.updateView(it.list)
        }
    }
}
