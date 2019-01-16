package com.jurgielewicz.forecastapp.ui.contract

import com.google.android.gms.location.places.Place
import com.jurgielewicz.forecastapp.base.BasePresenter
import com.jurgielewicz.forecastapp.dataModel.Response

interface CurrentWeatherContract {

    interface View{
        fun updateView(list: List<Response>?, p0: Place?)
    }

    interface Presenter:BasePresenter {
    }
}