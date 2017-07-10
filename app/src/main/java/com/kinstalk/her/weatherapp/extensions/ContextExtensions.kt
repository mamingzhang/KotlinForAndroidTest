package com.kinstalk.her.weatherapp.extensions

import android.content.Context
import android.support.v4.content.ContextCompat

/**
 * Created by horsege on 2017/7/10.
 */
fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)