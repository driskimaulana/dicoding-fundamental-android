package com.driskimaulana.mynavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavArgs
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs

class SecondFragment : Fragment() {

    val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_second, container, false)

        val tv_second = view.findViewById<TextView>(R.id.tv_second)

        tv_second.text = args.number.toString()

        tv_second.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.to_first)
        }

        return view
    }

}