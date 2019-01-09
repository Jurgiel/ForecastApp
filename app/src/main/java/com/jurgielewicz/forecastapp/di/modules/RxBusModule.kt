package com.jurgielewicz.forecastapp.di.modules

import com.jurgielewicz.forecastapp.RxBus.RxBus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RxBusModule {

    @Provides
    @Singleton
    fun provideRxBus(): RxBus {
        return RxBus
    }

}