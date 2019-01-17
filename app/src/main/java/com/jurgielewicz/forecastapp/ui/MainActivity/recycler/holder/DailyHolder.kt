package com.jurgielewicz.forecastapp.ui.MainActivity.recycler.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.jurgielewicz.forecastapp.Picasso.Picasso
import com.jurgielewicz.forecastapp.RxBus.RxBus
import com.jurgielewicz.forecastapp.dataModel.Periods
import kotlinx.android.synthetic.main.row_daily_weather.view.*

class DailyHolder( private val view: View): RecyclerView.ViewHolder(view) {

    fun bindItem(item: Periods?){
        view.weatherTextView_daily_weather_row.text = item?.weather
        view.maxTempTextView_daily_weather_row.text = item?.maxTempC.toString().plus("℃\t")
        view.minTempTextView_daily_weather_row.text = item?.minTempC.toString().plus("℃\t")
        Picasso.downloadImage(item?.icon, view.icon_daily_weather_row, 250, 250)
//        view.day_daily_weather_row.text = timeConverter(item?.dateTimeISO, 1)
//        view.dateTextView_Daily_Weather_Row.text = timeConverter(item?.dateTimeISO, 0)
    }
}