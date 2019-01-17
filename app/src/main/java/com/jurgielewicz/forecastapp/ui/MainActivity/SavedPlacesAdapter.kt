package com.jurgielewicz.forecastapp.ui.MainActivity

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jurgielewicz.forecastapp.R
import com.jurgielewicz.forecastapp.db.Place


class SavedPlacesAdapter(private val places: List<Place>): RecyclerView.Adapter<SavedHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val row = layoutInflater.inflate(R.layout.row_saved_place, parent, false)

        return SavedHolder(row)
    }

    override fun getItemCount(): Int {
        return places.size
    }

    override fun onBindViewHolder(holder: SavedHolder, position: Int) {
        holder.itemView.setOnClickListener {  }
        holder.bind(places[position].name.toString())
    }
}