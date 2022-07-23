package com.driskimaulana.wonderfulindonesia.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.driskimaulana.wonderfulindonesia.DetailActivity
import com.driskimaulana.wonderfulindonesia.R
import com.driskimaulana.wonderfulindonesia.model.ObjectWisata

class ObjectWisataAdapter(val listObjectWisata: ArrayList<ObjectWisata>) : RecyclerView.Adapter<ObjectWisataAdapter.ObjectWisataHolder>() {

    private lateinit var context: Context

    inner class ObjectWisataHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgObjectWisata: ImageView = itemView.findViewById(R.id.img_objectWisata)

        var tvObjectWisata: TextView = itemView.findViewById(R.id.tv_objectWisata)
        var tvDescription: TextView = itemView.findViewById(R.id.tv_deskripsiObjectWisata)
        var tvLocation: TextView = itemView.findViewById(R.id.tv_location)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectWisataHolder {
//        create view from xml file
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_object_wisata, parent, false)

        context = parent.context

        return  ObjectWisataHolder(view)
    }

    override fun onBindViewHolder(holder: ObjectWisataHolder, position: Int) {
        var currentObjectWisata: ObjectWisata = listObjectWisata[position]

        holder.tvObjectWisata.text = currentObjectWisata.name
        holder.tvDescription.text = currentObjectWisata.description
        holder.tvLocation.text = currentObjectWisata.location

        Glide.with(holder.itemView.context)
            .load(currentObjectWisata.imageCover)
            .apply(RequestOptions().override(350, 350))
            .into(holder.imgObjectWisata)


//        navigato to detail page
        holder.itemView.setOnClickListener{
            var intent: Intent = Intent(context, DetailActivity::class.java)

            intent.putExtra(DetailActivity.EXTRA_DETAIL_KEY, currentObjectWisata)

            context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return listObjectWisata.size
    }
}