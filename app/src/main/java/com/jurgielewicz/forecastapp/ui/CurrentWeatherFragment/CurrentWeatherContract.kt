package com.jurgielewicz.forecastapp.ui.CurrentWeatherFragment

import com.google.android.gms.location.places.Place
import com.jurgielewicz.forecastapp.base.BasePresenter
import com.jurgielewicz.forecastapp.dataModel.Response

interface CurrentWeatherContract {

    interface View{
        fun updateView(list: List<Response>?, p0: Place?)
        fun setImageSaved()
        fun setImageNotSaved()
    }

    interface Presenter:BasePresenter {
        fun save()
        fun delete()
        fun saveClicked()
        fun itemExists(lat: Double?, lng: Double?):Boolean
    }
}