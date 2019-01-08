package com.jurgielewicz.forecastapp.di.compoents

import com.jurgielewicz.forecastapp.di.modules.RetrofitModule
import com.jurgielewicz.forecastapp.ui.presenter.MainActivityPresenter
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component (modules = [RetrofitModule::class])
interface MainActivityComponent {
    fun inject(presenter: MainActivityPresenter)
}