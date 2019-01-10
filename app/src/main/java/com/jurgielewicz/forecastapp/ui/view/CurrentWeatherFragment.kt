package com.jurgielewicz.forecastapp.ui.view


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.location.places.Place

import com.jurgielewicz.forecastapp.R
import com.jurgielewicz.forecastapp.base.BaseFragment
import com.jurgielewicz.forecastapp.dataModel.Response
import com.jurgielewicz.forecastapp.ui.contract.CurrentWeatherContract
import com.jurgielewicz.forecastapp.ui.presenter.CurrentWeatherPresenter
import com.jurgielewicz.forecastapp.ui.view.recycler.adapter.HourlyAdapter
import kotlinx.android.synthetic.main.fragment_current_weather.view.*


class CurrentWeatherFragment : BaseFragment<CurrentWeatherPresenter>(), CurrentWeatherContract.View  {
    private lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_current_weather, container, false)
        rootView.hourlyRecycler.layoutManager = LinearLayoutManager(activity)
        rootView.hourlyRecycler.adapter = null

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }

    override fun instantiatePresenter(): CurrentWeatherPresenter {
        return CurrentWeatherPresenter(this)
    }

    override fun updateView(list: List<Response>?, p0: Place?) {
        val data = list?.get(0)?.periods?.get(0)

        rootView.cityTextView_CurrentLayout.text = p0?.name
        rootView.weatherTextView_CurrentLayout.text = data?.weather
        rootView.feelsLikeTextView_CurrentLayout.text = data?.feelsLikeC.toString().plus("℃\t")
        rootView.temperatureTextView_CurrentLayout.text = data?.tempC.toString().plus("℃\t")
        rootView.hourlyRecycler.adapter = HourlyAdapter(list)

    }

}
