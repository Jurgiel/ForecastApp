package com.jurgielewicz.forecastapp.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

//maybe this should be placed inside db package, not sure
@Entity
data class Place(val lat: Double,
                 val lng: Double,
                 val name: String){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}