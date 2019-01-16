package com.jurgielewicz.forecastapp.module

import android.arch.persistence.room.Room
import com.jurgielewicz.forecastapp.RxBus.RxBus
import com.jurgielewicz.forecastapp.db.PlaceDatabase
import com.jurgielewicz.forecastapp.retrofit.WeatherApi
import com.jurgielewicz.forecastapp.ui.contract.CurrentWeatherContract
import com.jurgielewicz.forecastapp.ui.contract.DailyWeatherContract
import com.jurgielewicz.forecastapp.ui.contract.MainActivityContract
import com.jurgielewicz.forecastapp.ui.presenter.CurrentWeatherPresenter
import com.jurgielewicz.forecastapp.ui.presenter.DailyWeatherPresenter
import com.jurgielewicz.forecastapp.ui.presenter.MainActivityPresenter
import com.jurgielewicz.forecastapp.utils.BASE_URL
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class  AppModule {
    val module = module(definition = {
        //Room DB
        single {
            Room.databaseBuilder(androidApplication(), PlaceDatabase::class.java, "PlaceDb")
                    .build()
        }
        //Place Dao
        single { get<PlaceDatabase>().placeDao() }

    })

    val presenterModule = module(definition = {

        //MainActivityPresenter
        factory<MainActivityContract.Presenter> { (v: MainActivityContract.View) ->
            MainActivityPresenter(v, get(), get(), get())
        }
        //CurrentWeatherPresenter
        factory<CurrentWeatherContract.Presenter>{ (v: CurrentWeatherContract.View) ->
            CurrentWeatherPresenter(v, get(), get())
        }

        //DailyWeatherPresenter
        factory<DailyWeatherContract.Presenter> { (v: DailyWeatherContract.View) ->
            DailyWeatherPresenter(v, get())
        }
    })

    val retrofitModule = module( definition =  {
        single <Retrofit>{ createRetrofit() }
        single { createRetrofitService(get()) }
    })

    val rxBusModule = module {
        single { RxBus }
    }

    fun createRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    fun createRetrofitService(retrofit: Retrofit): WeatherApi = retrofit.create(WeatherApi::class.java)


    val app = listOf(module, presenterModule, retrofitModule, rxBusModule)
}