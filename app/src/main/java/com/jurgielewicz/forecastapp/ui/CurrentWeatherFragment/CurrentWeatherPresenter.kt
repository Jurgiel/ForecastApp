package com.jurgielewicz.forecastapp.ui.CurrentWeatherFragment


import com.jurgielewicz.forecastapp.RxBus.RxBus
import com.jurgielewicz.forecastapp.RxBus.RxEvent
import com.jurgielewicz.forecastapp.db.Place
import com.jurgielewicz.forecastapp.db.PlaceDao
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CurrentWeatherPresenter(private val v: CurrentWeatherContract.View,
                              private val dao: PlaceDao,
                              private val bus: RxBus):  CurrentWeatherContract.Presenter {
    private var place: Place? = null
    private var exists = false
    private var composite: CompositeDisposable? = null

    init {
        bus.listen(RxEvent.EventShowCurrentWeather::class.java).subscribe {
            place = it.place
            v.updateView(it.list, place)
        itemExists()
        }
    }

    override fun save() {
        val dispose = Observable.just(dao)
                .subscribeOn(Schedulers.io())
                .subscribe { it.insert(place) }
        composite?.add(dispose)
    }

    override fun delete() {
        val dispose = Observable.just(dao)
                .subscribeOn(Schedulers.io())
                .subscribe { it.delete(place?.lat) }
        composite?.add(dispose)
    }

    override fun saveClicked() {
        when(exists){
            true ->{ delete()
                exists = false
                v.setImageNotSaved() }
            false -> {save()
                exists = true
                v.setImageSaved()}
        }
    }

    override fun itemExists() {
        val dispose = Observable.just(dao)
                .subscribeOn(Schedulers.io())
                .map { it -> it.exist(place?.lat, place?.lng) }
                .subscribe({exist -> v.setImageSaved()
                exists = true},
                        {notExist -> v.setImageNotSaved()
                        exists = false})
        composite?.add(dispose)
    }

    override fun onViewDestroyed() {
        super.onViewDestroyed()
        composite?.dispose()
    }
}