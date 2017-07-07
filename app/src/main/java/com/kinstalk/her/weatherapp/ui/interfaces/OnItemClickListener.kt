package com.kinstalk.her.weatherapp.ui.interfaces

import com.kinstalk.her.weatherapp.domain.model.Forecast

/**
 * Created by mamingzhang on 2017/7/6.
 */
interface OnItemClickListener {
    operator fun invoke(forecast: Forecast)
}