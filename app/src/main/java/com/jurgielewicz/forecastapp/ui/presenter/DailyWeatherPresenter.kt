package com.jurgielewicz.forecastapp.ui.presenter

import com.jurgielewicz.forecastapp.base.BasePresenter
import com.jurgielewicz.forecastapp.ui.contract.DailyWeatherContract.DailyWeatherView

class DailyWeatherPresenter(v: DailyWeatherView):BasePresenter<DailyWeatherView>(v)