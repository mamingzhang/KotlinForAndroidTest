package com.kinstalk.her.weatherapp.extensions

import android.content.Context
import android.view.View

/**
 * Created by mamingzhang on 2017/7/6.
 */

val View.ctx: Context
    get() = context

fun View.slideExit() {
    if (translationY == 0f) animate().translationY(-height.toFloat())
}

fun View.slideEnter() {
    if (translationY < 0f) animate().translationY(0f)
}

