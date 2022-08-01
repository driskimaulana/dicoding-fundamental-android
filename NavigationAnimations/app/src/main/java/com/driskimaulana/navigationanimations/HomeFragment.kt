package com.driskimaulana.navigationanimations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController


class HomeFragment : Fragment() {

    private lateinit var btnToFirst: Button
    private lateinit var btnToSecond: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        btnToFirst = view.findViewById(R.id.btn_toFirst)
        btnToSecond = view.findViewById(R.id.btn_toSecond)

        btnToFirst.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_firstFragment)
        }

        btnToSecond.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_secondFragment)
        }

        return view
    }

}