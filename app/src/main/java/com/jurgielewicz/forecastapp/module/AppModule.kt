package com.jurgielewicz.forecastapp.module

import android.arch.persistence.room.Room
import com.jurgielewicz.forecastapp.RxBus.RxBus
import com.jurgielewicz.forecastapp.db.PlaceDatabase
import com.jurgielewicz.forecastapp.retrofit.WeatherApi
import com.jurgielewicz.forecastapp.utils.BASE_URL
import com.squareup.moshi.Moshi
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


val roomModule = module {
        //RoomDb
        single {
            Room.databaseBuilder(androidApplication(), PlaceDatabase::class.java, "PlaceDB" )
        }

        //PlaceDao
        single { get<PlaceDatabase>().placeDao() }
    }
val retrofitModule = module {
    single { createRetrofit() }
    single { createRetrofitService(get()) }
}

val rxBusModule = module {
    single { get<RxBus>() }
}

fun createRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
fun createRetrofitService(retrofit: Retrofit):WeatherApi = retrofit.create(WeatherApi::class.java)
