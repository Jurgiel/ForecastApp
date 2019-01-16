package com.jurgielewicz.forecastapp.ui.CurrentWeatherFragment


import com.jurgielewicz.forecastapp.RxBus.RxBus
import com.jurgielewicz.forecastapp.RxBus.RxEvent
import com.jurgielewicz.forecastapp.db.Place
import com.jurgielewicz.forecastapp.db.PlaceDao
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class CurrentWeatherPresenter(private val v: CurrentWeatherContract.View,
                              private val dao: PlaceDao,
                              private val bus: RxBus):  CurrentWeatherContract.Presenter {
    lateinit var place: Place


    override fun onViewCreated() {
        bus.listen(RxEvent.EventShowCurrentWeather::class.java).subscribe {
            v.updateView(it.list, it.p0)
            place = Place(it.p0?.latLng?.latitude, it.p0?.latLng?.longitude, it.p0?.name as String)


        }
    }

    override fun save() {
        Observable.just(dao)
                .subscribeOn(Schedulers.io())
                .subscribe {  dao.insert(place) }
    }

    override fun itemExists(lat: Double?, lng: Double?):Boolean {
        var exist = false
        dao.exist(lat, lng)
                .subscribeOn(Schedulers.io())
                .filter { it -> it.name != null}
                .subscribe { exist = true  }
        return exist

    }

    override fun delete() {
        dao.deleteByLat(place?.lat)
    }

    override fun saveClicked() {
        if (itemExists(place?.lat, place?.lng)) {
            delete()
            v.setImageNotSaved()
        } else {
            save()
            v.setImageSaved()
        }
    }
}