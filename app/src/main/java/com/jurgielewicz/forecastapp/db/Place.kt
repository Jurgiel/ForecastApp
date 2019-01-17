package com.jurgielewicz.forecastapp.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Place(
                 val lat: Double?,
                 val lng: Double?,
                 val name: String?){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}

