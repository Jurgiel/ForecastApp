package com.jurgielewicz.forecastapp.ui.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jurgielewicz.forecastapp.R
import com.jurgielewicz.forecastapp.dataModel.Response
import com.jurgielewicz.forecastapp.ui.contract.DailyWeatherContract
import com.jurgielewicz.forecastapp.ui.presenter.DailyWeatherPresenter
import com.jurgielewicz.forecastapp.ui.view.recycler.adapter.DailyAdapter
import kotlinx.android.synthetic.main.fragment_daily_weather.view.*


class DailyWeatherFragment : Fragment(), DailyWeatherContract.View {
    private lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_daily_weather, container, false)
        rootView.dailyRecycler.layoutManager = LinearLayoutManager(activity)
        rootView.dailyRecycler.adapter = null

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    override fun updateView(list: List<Response>?) {
        rootView.dailyRecycler.adapter = DailyAdapter(list)
    }
}
