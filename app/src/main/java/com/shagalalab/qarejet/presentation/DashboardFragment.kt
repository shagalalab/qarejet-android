package com.shagalalab.qarejet.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.shagalalab.qarejet.R

class DashboardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context = requireContext()
        val frameLayout = FrameLayout(context)
        val textView = TextView(context)
        textView.text = "Dashboard Fragment"
        frameLayout.addView(textView)
        frameLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.amber))
        return frameLayout
    }
}
