package com.jurgielewicz.forecastapp.ui.contract

import android.widget.ImageView
import com.google.android.gms.location.places.Place
import com.jurgielewicz.forecastapp.base.BaseView
import com.jurgielewicz.forecastapp.dataModel.Response

interface CurrentWeatherContract {

    interface View{
        fun updateView(list: List<Response>?, p0: Place?)
    }

    interface Presenter {
        fun showWeather()
    }
}