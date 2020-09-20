package com.shagalalab.feature.splash.presentation

import com.shagalalab.core.usf.UsfViewModel
import com.shagalalab.core.utils.data.Resource
import com.shagalalab.core.utils.data.Status
import com.shagalalab.feature.splash.domain.CheckDataPopulatedUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

@FlowPreview
@ExperimentalCoroutinesApi
internal class SplashViewModel(
    private val checkDataPopulatedUseCase: CheckDataPopulatedUseCase
) : UsfViewModel<SplashEvent, SplashResult, SplashState, SplashEffect>() {

    override fun convertEventToResult(event: Flow<SplashEvent>): Flow<Resource<SplashResult>> {
        return event.transform { value: SplashEvent ->
            when (value) {
                SplashEvent.LoadEvent -> {
                    emit(Resource.loading())
                    val result = checkDataPopulatedUseCase.execute()
                    when (result.status) {
                        Status.LOADING -> {}
                        Status.SUCCESS -> emit(Resource.success(SplashResult.LoadResult(result.data ?: false)))
                        Status.ERROR -> emit(Resource.error<SplashResult>(result.message))
                    }
                }
            }
        }
    }

    override fun convertResultToViewState(oldState: SplashState?, result: Resource<SplashResult>): SplashState? {
        return when (result.status) {
            Status.LOADING -> SplashState(false)
            Status.SUCCESS -> {
                when (result.data) {
                    is SplashResult.LoadResult -> SplashState((result.data as SplashResult.LoadResult).populated)
                    else -> SplashState(false)
                }
            }
            Status.ERROR -> SplashState(false)
        }
    }
}
