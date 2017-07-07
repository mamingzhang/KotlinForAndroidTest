package com.kinstalk.her.weatherapp.domain

import com.kinstalk.her.weatherapp.data.server.Forecast
import com.kinstalk.her.weatherapp.data.server.ForecastResult
import com.kinstalk.her.weatherapp.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import com.kinstalk.her.weatherapp.domain.model.Forecast as ModelForecast


/**
 * Created by mamingzhang on 2017/7/5.
 */
class ForecastDataMapper {

    fun convertFromDataModel(zipCode: Long, forecast: ForecastResult) = with(forecast) {
        ForecastList(zipCode, city.name, city.country,
                convertForecastListToDomain(list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>):
            List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(forecast.dt,
                weather[0].description, temp.max.toInt(),
                temp.min.toInt(), generateIconUrl(weather[0].icon))
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

    private fun generateIconUrl(iconCode: String): String
            = "http://openweathermap.org/img/w/$iconCode.png"
}