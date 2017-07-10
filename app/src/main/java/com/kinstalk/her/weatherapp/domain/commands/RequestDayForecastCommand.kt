package com.kinstalk.her.weatherapp.domain.commands

import com.kinstalk.her.weatherapp.domain.datasource.ForecastProvider
import com.kinstalk.her.weatherapp.domain.model.Forecast

/**
 * Created by horsege on 2017/7/10.
 */
class RequestDayForecastCommand(
        val id: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()
) : Command<Forecast> {
    override fun execute() = forecastProvider.requestForecast(id)
}