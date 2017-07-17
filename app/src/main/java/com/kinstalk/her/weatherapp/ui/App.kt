package com.kinstalk.her.weatherapp.ui

import android.app.Application
import com.facebook.stetho.Stetho
import com.kinstalk.her.weatherapp.extensions.DelegatesExt

/**
 * Created by mamingzhang on 2017/7/6.
 */
class App : Application() {
    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        Stetho.initializeWithDefaults(this);
    }


}