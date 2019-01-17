package com.jurgielewicz.forecastapp.ui.MainActivity

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.row_saved_place.view.*

class SavedHolder(private val v:View): RecyclerView.ViewHolder(v){
    fun bind(s: String){
        v.savedCityTextView.text = s
    }
}