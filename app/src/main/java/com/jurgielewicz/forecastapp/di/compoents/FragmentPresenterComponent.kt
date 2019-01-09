package com.jurgielewicz.forecastapp.di.compoents

import com.jurgielewicz.forecastapp.di.modules.RxBusModule
import com.jurgielewicz.forecastapp.ui.presenter.CurrentWeatherPresenter
import com.jurgielewicz.forecastapp.ui.presenter.DailyWeatherPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RxBusModule::class])
interface FragmentPresenterComponent {
    fun inject(presenter: CurrentWeatherPresenter)
    fun inject(presenter: DailyWeatherPresenter)
}