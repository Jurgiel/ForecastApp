package com.jurgielewicz.forecastapp.retrofit

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecasts/{lat},{lng}?limit=14&")
    fun requestDailyWeather(@Path("lat") lat: Double?,
                            @Path("lng") lng: Double?,
                            @Query("client_id") client_id: String,
                            @Query("client_secret") client_secret: String): Observable<Result>

    @GET("forecasts/{lat},{lng}?filter=1hr&limit=24&")
    fun requestHourlyWeather(@Path("lat") lat: Double?,
                             @Path("lng") lng: Double?,
                             @Query("client_id") client_id: String,
                             @Query("client_secret") client_secret: String): Observable<Result>
}