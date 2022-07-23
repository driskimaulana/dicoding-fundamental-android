package com.driskimaulana.wonderfulindonesia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.driskimaulana.wonderfulindonesia.R
import com.driskimaulana.wonderfulindonesia.model.Review
import com.driskimaulana.wonderfulindonesia.model.ReviewData

class ReviewAdapter(val list: ArrayList<Review>) : RecyclerView.Adapter<ReviewAdapter.ReviewHolder>() {
    inner class ReviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvName = itemView.findViewById<TextView>(R.id.tv_name)
        var tvRating = itemView.findViewById<TextView>(R.id.tv_rating)
        var tvDescription = itemView.findViewById<TextView>(R.id.tv_desc)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.review_row, parent, false)

        return ReviewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewHolder, position: Int) {
        holder.tvName.text = list[position].name
        holder.tvRating.text = list[position].rate.toString()
        holder.tvDescription.text = list[position].description
    }

    override fun getItemCount(): Int {
        return list.size
    }
}