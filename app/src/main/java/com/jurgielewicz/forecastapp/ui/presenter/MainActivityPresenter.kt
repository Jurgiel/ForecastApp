package com.jurgielewicz.forecastapp.ui.presenter

import com.google.android.gms.location.places.Place
import com.jurgielewicz.forecastapp.base.BasePresenter
import com.jurgielewicz.forecastapp.ui.contract.MainActivityContract
import com.jurgielewicz.forecastapp.ui.contract.MainActivityContract.MainActivityView
import io.reactivex.disposables.Disposable


class MainActivityPresenter(view: MainActivityView): BasePresenter<MainActivityView>(view), MainActivityContract.MainActivityPresenter {
    private val TAG = "MainActivityPresenter"

    private var hourlySearched = true
    private var dailySearched = true
    private var place: Place? = null

    private var disposable: Disposable? = null
//    @Inject
//    lateinit var weatherApi: WeatherApi
//
//    @Inject
//    lateinit var bus: RxBus

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

    override fun search(p0: Place?) {
        val item = view.viewPagerCurrentItem()
        place = p0
//        when(item) {
//           0-> disposable = weatherApi
//                    .requestHourlyWeather(p0?.latLng?.latitude, p0?.latLng?.longitude, clientId, clientSecret)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe({ result -> bus.publish(RxEvent.EventShowCurrentWeather(result.response, place))
//                                setSearched(0) },
//                            { error -> Log.d(TAG, error.message) })
//
//            1-> disposable = weatherApi
//                    .requestDailyWeather(p0?.latLng?.latitude, p0?.latLng?.longitude, clientId, clientSecret)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe({ result -> bus.publish(RxEvent.EventShowDailyWeather(result.response))
//                                setSearched(1) },
//                            { error -> Log.d(TAG, error.message) })
//        }
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
}