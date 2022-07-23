package com.driskimaulana.wonderfulindonesia

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.driskimaulana.wonderfulindonesia.adapter.GalleryAdapter
import com.driskimaulana.wonderfulindonesia.adapter.ReviewAdapter
import com.driskimaulana.wonderfulindonesia.model.ObjectWisata
import com.driskimaulana.wonderfulindonesia.model.ReviewData

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DETAIL_KEY = "extra_detail_key"
    }

    private lateinit var img_cover: ImageView
    private lateinit var tv_name: TextView
    private lateinit var tv_location: TextView
    private lateinit var tv_description: TextView
    private lateinit var tv_rating: TextView
    private lateinit var tv_open: TextView
    private lateinit var rv_gallery: RecyclerView

    private lateinit var btn_favorite: Button
    private lateinit var btn_unfavorite: Button

    private lateinit var rv_review: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        var wisata = intent.getParcelableExtra<ObjectWisata>(EXTRA_DETAIL_KEY)
        supportActionBar?.title = wisata?.name
        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.green_primary)))

        initView()

        Glide.with(this)
            .load(wisata?.imageCover)
            .apply(RequestOptions().override(350, 350))
            .into(img_cover)

        tv_name.text = wisata?.name
        tv_description.text = wisata?.description
        tv_rating.text = wisata?.rating.toString()
        tv_open.text = wisata?.openSchedule
        tv_location.text = wisata?.location

        var adapter: GalleryAdapter = GalleryAdapter(wisata?.gallery)

        rv_gallery.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_gallery.adapter = adapter

        btn_favorite.setOnClickListener {
            btn_favorite.visibility = View.INVISIBLE
            btn_unfavorite.visibility = View.VISIBLE
        }

        btn_unfavorite.setOnClickListener {
            btn_favorite.visibility = View.VISIBLE
            btn_unfavorite.visibility = View.INVISIBLE
        }

        rv_review.layoutManager = LinearLayoutManager(this)
        var reviewAdapter: ReviewAdapter = ReviewAdapter(ReviewData.listData)
        rv_review.adapter = reviewAdapter



    }

    private fun initView() {
        img_cover = findViewById(R.id.img_cover)
        tv_name = findViewById(R.id.tv_title)
        tv_location = findViewById(R.id.tv_location)
        tv_description = findViewById(R.id.tv_deskripsiObjectWisata)
        tv_rating = findViewById(R.id.tv_rating)
        tv_open = findViewById(R.id.tv_open)
        rv_gallery = findViewById(R.id.rv_gallery)

        btn_favorite = findViewById(R.id.btn_favorite)
        btn_unfavorite = findViewById(R.id.btn_unfavorite)

        rv_review = findViewById(R.id.rv_review)
    }
}