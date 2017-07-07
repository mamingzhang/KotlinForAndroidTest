package com.kinstalk.her.weatherapp.extensions

/**
 * Created by mamingzhang on 2017/7/7.
 */

fun <K, V : Any> Map<K, V?>.toVarargArray(): Array<out Pair<K, V>> =
        map({ Pair(it.key, it.value!!) }).toTypedArray()
