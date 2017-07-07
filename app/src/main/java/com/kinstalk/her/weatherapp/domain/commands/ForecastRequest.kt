package com.kinstalk.her.weatherapp.domain.commands

import com.kinstalk.her.weatherapp.data.server.ForecastResult

/**
 * Created by mamingzhang on 2017/7/5.
 */
class ForecastRequest(val zipCode: Long) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "${com.kinstalk.her.weatherapp.domain.commands.ForecastRequest.Companion.URL}&APPID=${com.kinstalk.her.weatherapp.domain.commands.ForecastRequest.Companion.APP_ID}&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = java.net.URL(COMPLETE_URL + zipCode).readText()
        return com.google.gson.Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}