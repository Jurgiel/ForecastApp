package com.jurgielewicz.forecastapp.utils

import java.text.SimpleDateFormat
import java.util.*

fun timeConverter(string: String?, i: Int): String {
    val isoFormat = "yyyy-MM-dd'T'HH:mm:ss"
    var expectedFormat = "dd/MM"
    when(i){
        0 -> expectedFormat = "dd/MM"
        1 -> expectedFormat = "EEE"
        2 -> expectedFormat = "HH:mm"
        3 -> expectedFormat = "EEE, dd/MM"
    }
    val dateFormat = SimpleDateFormat(isoFormat, Locale.getDefault())
    val date = dateFormat.parse(string)
    return SimpleDateFormat(expectedFormat).format(date)
}




