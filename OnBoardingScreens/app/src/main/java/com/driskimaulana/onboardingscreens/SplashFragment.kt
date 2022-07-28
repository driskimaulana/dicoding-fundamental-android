package com.driskimaulana.onboardingscreens

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        Handler().postDelayed({

            if(isOnBoardingFinished())
            {
                findNavController().navigate(R.id.splash_to_home)
            }else {
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }

//            findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
        }, 3000)

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun isOnBoardingFinished() : Boolean {
        val sharedPreferences = activity?.getSharedPreferences("onboarding", Context.MODE_PRIVATE)

        return sharedPreferences?.getBoolean("is_finished_key", false) ?: false
    }

}