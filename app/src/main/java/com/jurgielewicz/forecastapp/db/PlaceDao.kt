package com.jurgielewicz.forecastapp.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.jurgielewicz.forecastapp.dataModel.Place
import io.reactivex.Observable

@Dao
interface PlaceDao {

    @get:Query("SELECT * FROM place")
    val all: Observable<List<Place>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(place: Place)

    @Query("DELETE FROM place WHERE lat = :lat")
    fun deleteByLat(lat: Long)

}