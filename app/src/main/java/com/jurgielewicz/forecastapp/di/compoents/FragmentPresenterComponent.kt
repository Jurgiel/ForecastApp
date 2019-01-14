package com.jurgielewicz.forecastapp.di.compoents

import android.content.Context
import com.jurgielewicz.forecastapp.di.modules.DaoModule
import com.jurgielewicz.forecastapp.di.modules.RxBusModule
import com.jurgielewicz.forecastapp.ui.presenter.CurrentWeatherPresenter
import com.jurgielewicz.forecastapp.ui.presenter.DailyWeatherPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RxBusModule::class, DaoModule::class])
interface FragmentPresenterComponent {
    fun inject(presenter: CurrentWeatherPresenter)
    fun inject(presenter: DailyWeatherPresenter)

    @Component.Builder
    interface Builder {
        fun build(): FragmentPresenterComponent

        fun rxBusModule(rxbusmodule: RxBusModule): Builder
        fun daoModule(daoModule: DaoModule): Builder

        @BindsInstance
        fun context(context: Context): Builder
    }
}