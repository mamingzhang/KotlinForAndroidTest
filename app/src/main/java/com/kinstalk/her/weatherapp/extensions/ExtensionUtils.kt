package com.kinstalk.her.weatherapp.extensions

import java.text.DateFormat
import java.util.*

/**
 * Created by horsege on 2017/7/10.
 */
fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}