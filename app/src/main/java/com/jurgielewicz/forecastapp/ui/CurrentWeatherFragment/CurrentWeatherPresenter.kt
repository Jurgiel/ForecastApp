package com.jurgielewicz.forecastapp.ui.CurrentWeatherFragment


import android.util.Log
import com.jurgielewicz.forecastapp.RxBus.RxBus
import com.jurgielewicz.forecastapp.RxBus.RxEvent
import com.jurgielewicz.forecastapp.db.Place
import com.jurgielewicz.forecastapp.db.PlaceDao
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CurrentWeatherPresenter(private val v: CurrentWeatherContract.View,
                              private val dao: PlaceDao,
                              private val bus: RxBus):  CurrentWeatherContract.Presenter {
    lateinit var place: Place


    override fun onViewCreated() {
        bus.listen(RxEvent.EventShowCurrentWeather::class.java).subscribe {
            v.updateView(it.list, it.p0)
            place = Place( it.p0?.latLng?.latitude, it.p0?.latLng?.longitude, it.p0?.name as String)


        }
    }

    override fun save() {
        Observable.just(dao)
                .subscribeOn(Schedulers.io())
                .subscribe {  dao.insert(place) }
    }

    override fun itemExists() {
         Observable.just(dao)
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                 .map { it -> it.exist(place.lat, place.lng) }
                .subscribe( { it -> saveClicked(true) },
                        {error -> saveClicked(false)})
    }


    override fun delete() {
        dao.deleteByLat(place.lat)
    }

    override fun saveClicked(b: Boolean) {
        when (b) {
            true -> {v.setImageNotSaved()
                    delete()}
            false -> {v.setImageSaved()
                save()}
        }
    }
}