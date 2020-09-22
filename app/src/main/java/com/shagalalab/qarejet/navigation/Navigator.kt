package com.shagalalab.qarejet.navigation

import androidx.navigation.NavController
import com.shagalalab.feature.splash.navigation.SplashNavigation
import com.shagalalab.qarejet.R

class Navigator : SplashNavigation {
    private var navController: NavController? = null

    fun bind(navController: NavController) {
        this.navController = navController
    }

    fun unbind() {
        navController = null
    }

    override fun onSplashSuccess() {
        navController?.navigate(R.id.action_splash_to_main)
    }
}
