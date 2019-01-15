package com.jurgielewicz.forecastapp.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Place::class], version = 1)
abstract class PlaceDatabase: RoomDatabase(){
    abstract fun placeDao(): PlaceDao
}