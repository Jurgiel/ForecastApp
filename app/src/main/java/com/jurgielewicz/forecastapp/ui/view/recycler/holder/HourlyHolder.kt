package com.jurgielewicz.forecastapp.ui.view.recycler.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.jurgielewicz.forecastapp.dataModel.Periods
import kotlinx.android.synthetic.main.row_hourly_weather.view.*
import javax.inject.Inject

class HourlyHolder(private val view: View): RecyclerView.ViewHolder(view) {

    fun bindItem(item: Periods?){
//        view.timeTextView_hourly_weather_row.text = timeConverter(item?.dateTimeISO, 2)
//        view.dayTextView_hourly_weather_row.text = timeConverter(item?.dateTimeISO, 1)
        view.maxTempTextView_hourly_weather_row.text = item?.maxTempC.toString().plus("℃\t")
        view.precipitationTextView_hourly_weather_row.text = "Precipitation: ".plus(item?.pop.toString()).plus("%")
        view.weatherTextView_hourly_weather_row.text = item?.weather
      // picasso.downloadImage(item?.icon, view.icon_hourly_weather_row, 200, 200)
    }
}