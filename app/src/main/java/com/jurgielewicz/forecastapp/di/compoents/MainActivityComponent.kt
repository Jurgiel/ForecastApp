package com.jurgielewicz.forecastapp.di.compoents

import com.jurgielewicz.forecastapp.base.BaseView
import com.jurgielewicz.forecastapp.di.modules.DaoModule
import com.jurgielewicz.forecastapp.di.modules.RetrofitModule
import com.jurgielewicz.forecastapp.di.modules.RxBusModule
import com.jurgielewicz.forecastapp.ui.presenter.MainActivityPresenter
import dagger.BindsInstance
import dagger.Component

import javax.inject.Singleton

@Singleton
@Component (modules = [RetrofitModule::class, RxBusModule::class, DaoModule::class])
interface MainActivityComponent {
    fun inject(presenter: MainActivityPresenter)

    @Component.Builder
    interface Builder {
        fun build(): MainActivityComponent

        fun retrofitModule(retrofitModule: RetrofitModule): Builder
        fun rxbusModule(rxBusModule: RxBusModule):Builder
        fun daoModule(daoModule: DaoModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}