package com.shagalalab.feature.splash.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.shagalalab.feature.splash.R
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.ext.android.viewModel

@FlowPreview
@ExperimentalCoroutinesApi
class SplashFragment : Fragment(R.layout.fragment_splash) {
    private val viewModel: SplashViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner) {
            println("ViewModel state is $it")
        }
        viewModel.processInput(SplashEvent.LoadEvent)
    }
}
