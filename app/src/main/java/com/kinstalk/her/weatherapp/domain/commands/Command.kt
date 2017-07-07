package com.kinstalk.her.weatherapp.domain.commands

/**
 * Created by mamingzhang on 2017/7/5.
 */
interface Command <T> {
    fun execute() : T
}