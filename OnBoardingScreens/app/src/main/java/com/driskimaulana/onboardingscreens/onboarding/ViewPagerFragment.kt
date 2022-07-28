package com.driskimaulana.onboardingscreens.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.driskimaulana.onboardingscreens.R
import com.driskimaulana.onboardingscreens.onboarding.screens.FirstScreenFragment
import com.driskimaulana.onboardingscreens.onboarding.screens.SecondScreenFragment
import com.driskimaulana.onboardingscreens.onboarding.screens.ThirdScreenFragment

class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_view_pager, container, false)

        val screenList = arrayListOf<Fragment>(
            FirstScreenFragment(),
            SecondScreenFragment(),
            ThirdScreenFragment()
        )

        val adapter = ViewPagerAdapter(
            screenList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)

        viewPager.adapter = adapter

        return view
    }

}