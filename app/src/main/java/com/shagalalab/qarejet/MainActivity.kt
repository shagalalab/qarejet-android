package com.shagalalab.qarejet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shagalalab.feature.splash.presentation.SplashFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, SplashFragment())
            .commit()
    }
}
