package com.driskimaulana.wonderfulindonesia.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.driskimaulana.wonderfulindonesia.R
import com.driskimaulana.wonderfulindonesia.adapter.ObjectWisataAdapter
import com.driskimaulana.wonderfulindonesia.utils.Utils

class FavoriteFragment : Fragment() {


    var mContext: Context? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var rv_objectWisata: RecyclerView = view.findViewById(R.id.rv_objectWisata)

        rv_objectWisata.layoutManager = LinearLayoutManager(this.context)

        var wisatas = Utils.getInstance(mContext)?.favoriteObjectWisata

        var adapter: ObjectWisataAdapter = ObjectWisataAdapter(wisatas)

        rv_objectWisata.adapter = adapter

    }


}