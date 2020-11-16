package com.shagalalab.qarejet.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.shagalalab.qarejet.R
import com.shagalalab.qarejet.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.activity_root.*

class MainFragment : Fragment() {
    private lateinit var fragmentMainBinding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMainBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return fragmentMainBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(requireActivity(), R.id.mainNavHost)
        fragmentMainBinding.bottomNavigation.setupWithNavController(navController)

        val rootNavController = Navigation.findNavController(requireActivity(),R.id.root_nav_host)

        fragmentMainBinding.homeBottomFab.setOnClickListener {
            rootNavController.navigate(R.id.action_mainFragment_to_newTransactionFragment)
        }
    }
}
