package com.jurgielewicz.forecastapp.ui.presenter


import com.jurgielewicz.forecastapp.RxBus.RxBus
import com.jurgielewicz.forecastapp.RxBus.RxEvent
import com.jurgielewicz.forecastapp.db.Place
import com.jurgielewicz.forecastapp.db.PlaceDao
import com.jurgielewicz.forecastapp.ui.contract.CurrentWeatherContract
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class CurrentWeatherPresenter(private val v: CurrentWeatherContract.View,
                              private val dao: PlaceDao,
                              private val bus: RxBus):  CurrentWeatherContract.Presenter {


    fun save() {
        Observable.just(dao)
                .subscribeOn(Schedulers.io())
                .subscribe { it -> it.insert(Place(0.0, 1.1, "name")) }
    }

    override fun onViewCreated() {
        bus.listen(RxEvent.EventShowCurrentWeather::class.java).subscribe {
            v.updateView(it.list, it.p0)

        }
    }
}