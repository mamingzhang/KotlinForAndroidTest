package com.kinstalk.her.weatherapp.data.db

import com.kinstalk.her.weatherapp.domain.datasource.ForecastDataSource
import com.kinstalk.her.weatherapp.domain.model.Forecast
import com.kinstalk.her.weatherapp.domain.model.ForecastList
import com.kinstalk.her.weatherapp.extensions.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * Created by mamingzhang on 2017/7/7.
 */
class ForecastDb(val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
                 val dataMapper: DbDataMapper = DbDataMapper()) : ForecastDataSource {
    override fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {
        val dailyRequest = "${DayForecastTable.CITY_ID} = ? AND ${DayForecastTable.DATE} >= ?"
        val dailyForecast = select(DayForecastTable.NAME)
                .whereSimple(dailyRequest, zipCode.toString(), date.toString())
                .parseList { DayForecast(HashMap(it)) }

        val city = select(CityForecastTable.NAME)
                .whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                .parseOpt { CityForecast(HashMap(it), dailyForecast) }

        if (city != null) dataMapper.convertToDomain(city) else null
    }

    fun saveForecast(forecast: ForecastList) = forecastDbHelper.use {

        clear(CityForecastTable.NAME)
        clear(DayForecastTable.NAME)

        with(dataMapper.convertFromDomain(forecast)) {
            insert(CityForecastTable.NAME, *map.toVarargArray())
            dailyForecast.forEach { insert(DayForecastTable.NAME, *it.map.toVarargArray()) }
        }
    }

    override fun requestDayForecast(id: Long): Forecast? = forecastDbHelper.use {
        val forecast = select(DayForecastTable.NAME).byId(id).
                parseOpt { DayForecast(HashMap(it)) }
        forecast?.let { dataMapper.convertDayToDomain(it) }
    }
}