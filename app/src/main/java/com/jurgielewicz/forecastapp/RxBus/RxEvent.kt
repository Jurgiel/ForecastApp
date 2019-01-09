package com.jurgielewicz.forecastapp.RxBus

import com.google.android.gms.location.places.Place
import com.jurgielewicz.forecastapp.dataModel.Response

class RxEvent {
    data class EventShowCurrentWeather (val list: List<Response>?, val p0: Place?)
    data class EventShowDailyWeather (val list: List<Response>?)
}