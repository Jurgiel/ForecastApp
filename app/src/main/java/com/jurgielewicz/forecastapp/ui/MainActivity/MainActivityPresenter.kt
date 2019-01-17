package com.jurgielewicz.forecastapp.ui.MainActivity

import android.util.Log
import com.google.android.gms.location.places.Place
import com.jurgielewicz.forecastapp.RxBus.RxBus
import com.jurgielewicz.forecastapp.RxBus.RxEvent
import com.jurgielewicz.forecastapp.db.PlaceDao
import com.jurgielewicz.forecastapp.retrofit.WeatherApi
import com.jurgielewicz.forecastapp.utils.CLIENT_ID
import com.jurgielewicz.forecastapp.utils.CLIENT_SECRET
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class MainActivityPresenter(private val view: MainActivityContract.View,
                            private val dao: PlaceDao,
                            private val weatherApi: WeatherApi,
                            private val bus: RxBus):  MainActivityContract.Presenter {

    private val TAG = "MainActivityPresenter"
    private var hourlySearched = true
    private var dailySearched = true
    private var place: com.jurgielewicz.forecastapp.db.Place? = null
    private var disposable: Disposable? = null
    lateinit var savedPlaces: List<com.jurgielewicz.forecastapp.db.Place>

    override fun onViewCreated() {
        view.initView()
    }

    override fun handlePageListener() {
        val item = view.viewPagerCurrentItem()
        if(item == 0 && !hourlySearched){
            search(place)
        }else if (item == 1 && !dailySearched){
            search(place)
        }
    }

    override fun searchClicked(p0: Place?) {
        val p: com.jurgielewicz.forecastapp.db.Place? = com.jurgielewicz.forecastapp.db.Place(p0?.latLng?.latitude, p0?.latLng?.longitude, p0?.name.toString())
       place = p
        search(p)
    }

    override fun search(place: com.jurgielewicz.forecastapp.db.Place?) {
        val item = view.viewPagerCurrentItem()
        when(item) {
           0-> disposable = weatherApi
                    .requestHourlyWeather(place?.lat, place?.lng, CLIENT_ID, CLIENT_SECRET)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ result -> bus.publish(RxEvent.EventShowCurrentWeather(result.response, place))
                                setSearched(0) },
                            { error -> Log.d(TAG, error.message) })

            1-> disposable = weatherApi
                    .requestDailyWeather(place?.lat, place?.lng, CLIENT_ID, CLIENT_SECRET)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ result -> bus.publish(RxEvent.EventShowDailyWeather(result.response))
                                setSearched(1) },
                            { error -> Log.d(TAG, error.message) })
        }
    }

    override fun setSearched(i: Int) {
        when(i){
            0 -> hourlySearched = true
            1 -> dailySearched = true
            2 -> {
                hourlySearched = false
                dailySearched = false
            }

        }
    }

    override fun drawerOpened() {
        dao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result -> savedPlaces = result
                            view.showSavedPlaces(result)}
    }

    override fun itemClicked(position: Int) {
        val place = savedPlaces[position]
        search(place)
    }
}