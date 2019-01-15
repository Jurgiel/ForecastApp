package com.jurgielewicz.forecastapp.ui.presenter


import com.jurgielewicz.forecastapp.base.BaseFragmentPresenter
import com.jurgielewicz.forecastapp.ui.contract.CurrentWeatherContract

class CurrentWeatherPresenter(private val v: CurrentWeatherContract.View):BaseFragmentPresenter<CurrentWeatherContract.View>(v){

//    @Inject
//    lateinit var bus: RxBus



    override fun onViewCreated() {
//        bus.listen(RxEvent.EventShowCurrentWeather::class.java).subscribe {
//            v.updateView(it.list, it.p0)
//            Log.d("CurrentWeatherPresenter", "323232")
        }
    }
