package com.jurgielewicz.forecastapp.ui.CurrentWeatherFragment

import com.google.android.gms.location.places.Place
import com.jurgielewicz.forecastapp.base.BasePresenter
import com.jurgielewicz.forecastapp.dataModel.Response
import io.reactivex.Single

interface CurrentWeatherContract {

    interface View{
        fun updateView(list: List<Response>?, place: com.jurgielewicz.forecastapp.db.Place?)
        fun setImageSaved()
        fun setImageNotSaved()
    }

    interface Presenter:BasePresenter {
        fun save()
        fun delete()
        fun saveClicked()
        fun itemExists()
    }
}