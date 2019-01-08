package com.jurgielewicz.forecastapp.dataModel


data class Periods(val timestamp: Long?,
                   val dateTimeISO: String?,
                   val tempC: Int?,
                   val maxTempC: Int?,
                   val minTempC: Int?,
                   val avgTempC: Int?,
                   val humidity: Int?,
                   val pop: Double?,
                   val feelsLikeC: Int?,
                   val weather: String?,
                   val weatherPrimary: String?,
                   val icon: String?,
                   val windSpeedKPH: Int?,
                   val sunriseISO: String?,
                   val sunsetISO: String?)
data class Response(val periods: List<Periods>?)


data class Result(val response: List<Response>?)