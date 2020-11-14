package com.shagalalab.feature.stats.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.shagalalab.feature.stats.R
import com.shagalalab.feature.stats.databinding.FragmentStatsBinding

class StatsFragment : Fragment() {

    companion object {
        const val TRANSACTION_TYPE_INCOME = 0
        const val TRANSACTION_TYPE_EXPENSE = 1
    }

    private lateinit var fragmentStatsBinding: FragmentStatsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentStatsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_stats, container, false)
        return fragmentStatsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentStatsBinding.statsTabLayout.getTabAt(TRANSACTION_TYPE_EXPENSE)?.select()
        fragmentStatsBinding.statsTabLayout.addOnTabSelectedListener(object :
                TabLayout.OnTabSelectedListener {
                override fun onTabReselected(tab: TabLayout.Tab?) {
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabSelected(tab: TabLayout.Tab?) {
                    fragmentStatsBinding.tvMessage.text = "${tab?.text} tab selected"
                }
            })
    }
}
