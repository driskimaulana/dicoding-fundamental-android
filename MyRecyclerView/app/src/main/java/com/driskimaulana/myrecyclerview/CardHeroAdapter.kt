package com.driskimaulana.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardHeroAdapter(val listHero: ArrayList<Hero>) : RecyclerView.Adapter<CardHeroAdapter.CardViewHolder>() {
    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tv_item_name)
        val tvDetail = itemView.findViewById<TextView>(R.id.tv_item_description)
        val imgPhoto = itemView.findViewById<ImageView>(R.id.img_item_photo)
        val btnFavorite = itemView.findViewById<Button>(R.id.btn_favorite)
        val btnShare = itemView.findViewById<Button>(R.id.btn_share)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_card_hero, parent, false)

        return  CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val hero: Hero = listHero[position]

        Glide.with(holder.itemView.context)
            .load(hero.photo)
            .apply(RequestOptions().override(350, 350))
            .into(holder.imgPhoto)

        holder.tvName.text = hero.name
        holder.tvDetail.text = hero.detail

        holder.btnFavorite.setOnClickListener{
            Toast.makeText(holder.itemView.context,"${hero.name} is added to favorite", Toast.LENGTH_SHORT).show()
        }

        holder.btnShare.setOnClickListener{
            Toast.makeText(holder.itemView.context, "${hero.name} is shared", Toast.LENGTH_SHORT).show()
        }

        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "${hero.name} is picked", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return listHero.size
    }
}