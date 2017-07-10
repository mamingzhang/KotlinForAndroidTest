package com.kinstalk.her.weatherapp.domain.commands

import com.kinstalk.her.weatherapp.data.server.ForecastByZipCodeRequest
import com.kinstalk.her.weatherapp.data.server.ServerDataMapper
import com.kinstalk.her.weatherapp.domain.datasource.ForecastProvider
import com.kinstalk.her.weatherapp.domain.model.ForecastList

/**
 * Created by mamingzhang on 2017/7/5.
 */
class RequestForecastCommand(private val zipCode: Long, val forecastProvider: ForecastProvider = ForecastProvider()) : Command<ForecastList> {
    companion object {
        val DAYS = 7
    }

    override fun execute() = forecastProvider.requestByZipCode(zipCode, DAYS)
}