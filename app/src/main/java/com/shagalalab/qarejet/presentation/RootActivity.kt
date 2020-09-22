package com.shagalalab.qarejet.presentation

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.shagalalab.qarejet.R
import com.shagalalab.qarejet.navigation.Navigator
import org.koin.android.ext.android.inject

class RootActivity : AppCompatActivity(R.layout.activity_root) {
    private val navigator: Navigator by inject()

    override fun onResume() {
        super.onResume()
        navigator.bind(findNavController(R.id.root_nav_host))
    }

    override fun onPause() {
        navigator.unbind()
        super.onPause()
    }
}
