package com.jurgielewicz.forecastapp.ui.DailyWeatherFragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jurgielewicz.forecastapp.R
import com.jurgielewicz.forecastapp.dataModel.Response
import com.jurgielewicz.forecastapp.ui.DailyWeatherFragment.DailyWeatherContract
import com.jurgielewicz.forecastapp.ui.MainActivity.recycler.adapter.DailyAdapter
import kotlinx.android.synthetic.main.fragment_daily_weather.view.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class DailyWeatherFragment : Fragment(), DailyWeatherContract.View {
    private lateinit var rootView: View
    private val presenter: DailyWeatherContract.Presenter by inject { parametersOf(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_daily_weather, container, false)
        rootView.dailyRecycler.layoutManager = LinearLayoutManager(activity)
        rootView.dailyRecycler.adapter = null

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }


    override fun updateView(list: List<Response>?) {
        rootView.dailyRecycler.adapter = DailyAdapter(list)
    }
}
