package com.shagalalab.feature.splash.di

import com.shagalalab.feature.splash.data.Accounts
import com.shagalalab.feature.splash.data.Categories
import com.shagalalab.feature.splash.domain.CheckDataPopulatedUseCase
import com.shagalalab.feature.splash.presentation.SplashViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@FlowPreview
@ExperimentalCoroutinesApi
object FeatureSplash {
    val module = module {
        factory {
            CheckDataPopulatedUseCase(
                get(),
                get(),
                get(),
                Accounts.getDefaultAccounts(androidContext()),
                Categories.getDefaultCategories(androidContext())
            )
        }

        viewModel {
            SplashViewModel(get())
        }
    }
}
