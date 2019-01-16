package com.jurgielewicz.forecastapp.ui.contract

import com.jurgielewicz.forecastapp.dataModel.Response

interface DailyWeatherContract {

    interface View {
        fun updateView(list: List<Response>?)
    }
    interface Presenter {
        fun onViewCreated()
    }
}