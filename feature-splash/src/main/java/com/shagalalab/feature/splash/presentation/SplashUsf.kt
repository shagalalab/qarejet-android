package com.shagalalab.feature.splash.presentation

import com.shagalalab.core.usf.ViewEffect
import com.shagalalab.core.usf.ViewEvent
import com.shagalalab.core.usf.ViewResult
import com.shagalalab.core.usf.ViewState

internal sealed class SplashEvent : ViewEvent {
    object LoadEvent : SplashEvent()
}

internal sealed class SplashResult : ViewResult {
    data class LoadResult(val populated: Boolean) : SplashResult()
}

internal data class SplashState(
    val isDataPopulated: Boolean
) : ViewState

internal sealed class SplashEffect : ViewEffect
