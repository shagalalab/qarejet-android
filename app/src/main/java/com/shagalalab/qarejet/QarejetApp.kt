package com.shagalalab.qarejet

import android.app.Application
import com.shagalalab.core.prefs.di.CorePrefs
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class QarejetApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@QarejetApp)
            modules(listOf(
                CorePrefs.module
            ))
        }
    }
}
