package com.jurgielewicz.forecastapp.di.compoents

import com.jurgielewicz.forecastapp.di.modules.RetrofitModule
import com.jurgielewicz.forecastapp.ui.presenter.MainActivityPresenter
import dagger.Component

import javax.inject.Singleton

@Singleton
@Component (modules = [RetrofitModule::class])
interface MainActivityComponent {
    fun inject(presenter: MainActivityPresenter)

    @Component.Builder
    interface Builder {
        fun build(): MainActivityComponent

        fun retrofitModule(retrofitModule: RetrofitModule): Builder
    }
}