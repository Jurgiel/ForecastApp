package com.jurgielewicz.forecastapp.ui.DailyWeatherFragment

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jurgielewicz.forecastapp.R
import com.jurgielewicz.forecastapp.dataModel.Response

class DailyAdapter(private val list: List<Response>?): RecyclerView.Adapter<DailyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val weatherRow = layoutInflater.inflate(R.layout.row_daily_weather, parent, false)

        return DailyHolder(weatherRow)
    }

    override fun getItemCount(): Int {
        return list?.get(0)?.periods?.lastIndex!! //cant return Int?
    }

    override fun onBindViewHolder(holder: DailyHolder, position: Int) {
        val data = list?.get(0)?.periods?.get(position)
        holder.bindItem(data)
    }
}