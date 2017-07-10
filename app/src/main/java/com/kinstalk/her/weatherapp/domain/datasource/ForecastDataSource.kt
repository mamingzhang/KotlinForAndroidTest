package com.kinstalk.her.weatherapp.domain.datasource

import com.kinstalk.her.weatherapp.domain.model.Forecast
import com.kinstalk.her.weatherapp.domain.model.ForecastList

/**
 * Created by horsege on 2017/7/10.
 */
interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?

}