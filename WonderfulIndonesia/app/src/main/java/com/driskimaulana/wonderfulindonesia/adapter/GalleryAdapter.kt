package com.driskimaulana.wonderfulindonesia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.driskimaulana.wonderfulindonesia.R

class GalleryAdapter(val list: IntArray?) : RecyclerView.Adapter<GalleryAdapter.GalleryHolder>() {

    inner class GalleryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgItem: ImageView = itemView.findViewById(R.id.img_gallery)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.object_wisata_gallery, parent, false)

        return GalleryHolder(view)
    }

    override fun onBindViewHolder(holder: GalleryHolder, position: Int) {
        if (list != null)
        {
            Glide.with(holder.itemView)
                .load(list[position])
                .apply(RequestOptions().override(350, 350))
                .into(holder.imgItem)
        }

    }

    override fun getItemCount(): Int {
        return if(list != null) list.size else 0
    }

}


