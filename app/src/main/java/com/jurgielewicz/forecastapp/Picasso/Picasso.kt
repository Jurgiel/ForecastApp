package com.jurgielewicz.forecastapp.Picasso

import android.util.Log
import android.widget.ImageView
import com.squareup.picasso.Picasso

object Picasso {
    fun downloadImage(iconId: String?, imageView: ImageView, width: Int, height: Int){
        try{
            Picasso.get()
                    .load("https://cdn.aerisapi.com/wxicons/v2/$iconId")
                    .resize(width, height)
                    .centerInside()
                    .into(imageView)
        } catch (e: Exception) {
            Log.d("downloadImage", e.message)
        }
    }
}