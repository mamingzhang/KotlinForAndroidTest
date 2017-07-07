package com.kinstalk.her.weatherapp.domain.commands

import com.kinstalk.her.weatherapp.domain.model.ForecastList

/**
 * Created by mamingzhang on 2017/7/5.
 */
class RequestForecastCommand(private val zipCode: Long) : Command<ForecastList> {
    override fun execute(): ForecastList {
        var forecastRequest = ForecastRequest(zipCode)
        return com.kinstalk.her.weatherapp.domain.ForecastDataMapper().convertFromDataModel(zipCode, forecastRequest.execute())
    }
}