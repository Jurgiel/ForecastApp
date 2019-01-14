package com.jurgielewicz.forecastapp.ui.contract

import com.jurgielewicz.forecastapp.base.BaseView
import com.jurgielewicz.forecastapp.dataModel.Response

interface DailyWeatherContract {

    interface View:BaseView {
        fun updateView(list: List<Response>?)
    }
}