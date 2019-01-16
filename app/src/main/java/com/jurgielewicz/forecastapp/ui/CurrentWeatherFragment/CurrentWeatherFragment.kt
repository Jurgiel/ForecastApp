package com.jurgielewicz.forecastapp.ui.CurrentWeatherFragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.location.places.Place

import com.jurgielewicz.forecastapp.R
import com.jurgielewicz.forecastapp.dataModel.Response
import com.jurgielewicz.forecastapp.ui.MainActivity.recycler.adapter.HourlyAdapter
import kotlinx.android.synthetic.main.fragment_current_weather.view.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class CurrentWeatherFragment : Fragment(), CurrentWeatherContract.View  {
    private lateinit var rootView: View
    private val presenter: CurrentWeatherContract.Presenter by inject { parametersOf(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_current_weather, container, false)
        rootView.hourlyRecycler.layoutManager = LinearLayoutManager(activity)
        rootView.hourlyRecycler.adapter = null
        rootView.saveLocationButton.setOnClickListener { presenter.saveClicked() }
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }


    override fun updateView(list: List<Response>?, p0: Place?) {
        val data = list?.get(0)?.periods?.get(0)

        rootView.cityTextView_CurrentLayout.text = p0?.name
        rootView.weatherTextView_CurrentLayout.text = data?.weather
        rootView.feelsLikeTextView_CurrentLayout.text = data?.feelsLikeC.toString().plus("℃\t")
        rootView.temperatureTextView_CurrentLayout.text = data?.tempC.toString().plus("℃\t")
        rootView.hourlyRecycler.adapter = HourlyAdapter(list)

    }

    override fun setImageSaved() {
        rootView.saveLocationButton.setImageResource(R.drawable.ic_saved)
    }

    override fun setImageNotSaved() {
        rootView.saveLocationButton.setImageResource(R.drawable.ic_not_saved)
    }
}
