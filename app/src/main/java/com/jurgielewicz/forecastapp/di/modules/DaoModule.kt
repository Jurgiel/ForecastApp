package com.jurgielewicz.forecastapp.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.jurgielewicz.forecastapp.db.PlaceDao
import com.jurgielewicz.forecastapp.db.PlaceDatabase
import dagger.Module
import dagger.Provides

@Module
object DaoModule {
    private const val DATABASE_NAME = "PlaceDB"


    @Provides
    @JvmStatic
    internal fun providePlaceDatabase(context: Context): PlaceDatabase{
        return Room.databaseBuilder(context.applicationContext, PlaceDatabase::class.java, DATABASE_NAME).build()
    }


    @Provides
    @JvmStatic
    internal fun providePlaceDao(db: PlaceDatabase): PlaceDao {
        return db.placeDao()
    }
}