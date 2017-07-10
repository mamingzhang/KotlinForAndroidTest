package com.kinstalk.her.weatherapp.data.server

import com.kinstalk.her.weatherapp.data.db.ForecastDb
import com.kinstalk.her.weatherapp.domain.datasource.ForecastDataSource
import com.kinstalk.her.weatherapp.domain.model.Forecast
import com.kinstalk.her.weatherapp.domain.model.ForecastList

/**
 * Created by horsege on 2017/7/10.
 */
class ForecastServer(val dataMapper: ServerDataMapper = ServerDataMapper(),
                     val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {
    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }

    override fun requestDayForecast(id: Long): Forecast?
            = throw UnsupportedOperationException()
}