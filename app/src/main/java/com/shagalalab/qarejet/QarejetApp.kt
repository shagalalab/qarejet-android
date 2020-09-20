package com.shagalalab.qarejet

import android.app.Application
import com.shagalalab.core.data.di.CoreData
import com.shagalalab.core.prefs.di.CorePrefs
import com.shagalalab.feature.splash.di.FeatureSplash
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@FlowPreview
@ExperimentalCoroutinesApi
class QarejetApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@QarejetApp)
            modules(
                listOf(
                    CoreData.module,
                    CorePrefs.module,
                    FeatureSplash.module
                )
            )
        }
    }
}
