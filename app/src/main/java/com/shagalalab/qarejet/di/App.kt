package com.shagalalab.qarejet.di

import com.shagalalab.feature.splash.navigation.SplashNavigation
import com.shagalalab.qarejet.navigation.Navigator
import org.koin.dsl.binds
import org.koin.dsl.module

object App {
    val module = module {
        single { Navigator() } binds arrayOf(SplashNavigation::class)
    }
}
