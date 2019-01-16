package com.jurgielewicz.forecastapp.ui.MainActivity.recycler.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jurgielewicz.forecastapp.R
import com.jurgielewicz.forecastapp.dataModel.Response
import com.jurgielewicz.forecastapp.ui.MainActivity.recycler.holder.HourlyHolder

class HourlyAdapter(private val list: List<Response>?): RecyclerView.Adapter<HourlyHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val weatherRow = layoutInflater.inflate(R.layout.row_hourly_weather, parent, false)

        return HourlyHolder(weatherRow)
    }

    override fun getItemCount(): Int {
        return list?.get(0)?.periods?.size!!
    }

    override fun onBindViewHolder(holder: HourlyHolder, position: Int) {
        val data = list?.get(0)?.periods?.get(position)
        holder.bindItem(data)
    }

}