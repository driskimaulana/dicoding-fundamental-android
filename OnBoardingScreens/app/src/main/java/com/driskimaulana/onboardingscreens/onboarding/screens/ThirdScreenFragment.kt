package com.driskimaulana.onboardingscreens.onboarding.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.driskimaulana.onboardingscreens.R

class ThirdScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third_screen, container, false)

        val finish = view.findViewById<TextView>(R.id.btn_finish)

        val viewAdapter = activity?.findViewById<ViewPager2>(R.id.viewPager)

        finish.setOnClickListener{

            onBoardingFinished()
            findNavController().navigate(R.id.view_pager_to_home)
        }

        return view
    }

    private fun onBoardingFinished()
    {
        val sharedPreferences = activity?.getSharedPreferences("onboarding", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()

        editor?.putBoolean("is_finished_key", true)

        editor?.apply()
    }
}