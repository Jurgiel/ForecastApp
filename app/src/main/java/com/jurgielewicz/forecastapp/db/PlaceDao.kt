package com.jurgielewicz.forecastapp.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable

@Dao
interface PlaceDao {

    @Query("SELECT * FROM place")
    fun getAll(): Flowable<List<Place>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(place: Place)

    @Query("DELETE FROM place WHERE lat = :lat")
    fun deleteByLat(lat: Long)

}