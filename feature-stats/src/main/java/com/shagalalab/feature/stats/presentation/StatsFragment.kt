package com.shagalalab.feature.stats.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.shagalalab.feature.stats.R
import com.shagalalab.feature.stats.databinding.FragmentStatsBinding

class StatsFragment : Fragment(R.layout.fragment_stats) {

    companion object {
        const val TRANSACTION_TYPE_EXPENSE = 1
    }

    private lateinit var binding: FragmentStatsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStatsBinding.bind(view)
        binding.statsTabLayout.getTabAt(TRANSACTION_TYPE_EXPENSE)?.select()
        binding.statsTabLayout.addOnTabSelectedListener(object :
                TabLayout.OnTabSelectedListener {
                override fun onTabReselected(tab: TabLayout.Tab?) {
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabSelected(tab: TabLayout.Tab?) {
                    binding.tvMessage.text = "${tab?.text} tab selected"
                }
            })
    }
}
