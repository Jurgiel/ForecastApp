package com.jurgielewicz.forecastapp.ui.CurrentWeatherFragment

import android.support.v7.widget.RecyclerView
import android.view.View
import com.jurgielewicz.forecastapp.Picasso.Picasso
import com.jurgielewicz.forecastapp.dataModel.Periods
import com.jurgielewicz.forecastapp.utils.timeConverter
import kotlinx.android.synthetic.main.row_hourly_weather.view.*

class HourlyHolder(private val view: View): RecyclerView.ViewHolder(view) {

    fun bindItem(item: Periods?){

        view.maxTempTextView_hourly_weather_row.text = item?.maxTempC.toString().plus("℃\t")
        view.precipitationTextView_hourly_weather_row.text = "Precipitation: ".plus(item?.pop.toString()).plus("%")
        view.weatherTextView_hourly_weather_row.text = item?.weather
        view.dayTextView_hourly_weather_row.text = timeConverter(item?.dateTimeISO, 1)
        view.timeTextView_hourly_weather_row.text = timeConverter(item?.dateTimeISO, 2)
        Picasso.downloadImage(item?.icon, view.icon_hourly_weather_row, 250, 250)

    }
}