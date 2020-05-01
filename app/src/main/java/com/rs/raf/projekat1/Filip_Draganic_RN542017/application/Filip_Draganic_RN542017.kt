package com.rs.raf.projekat1.Filip_Draganic_RN542017.application

import android.app.Application
import timber.log.Timber

class Filip_Draganic_RN542017 : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
        Timber.e("pokrenuto")
    }

}