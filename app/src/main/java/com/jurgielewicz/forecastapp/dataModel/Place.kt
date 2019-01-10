package com.jurgielewicz.forecastapp.dataModel

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

//maybe this should be placed inside db package, not sure
@Entity
data class Place(@PrimaryKey val id: Int,
                 val lat: Double,
                 val lng: Double,
                 val name: String)