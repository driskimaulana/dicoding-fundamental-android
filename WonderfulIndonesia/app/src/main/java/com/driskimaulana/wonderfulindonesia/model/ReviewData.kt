package com.driskimaulana.wonderfulindonesia.model

import com.driskimaulana.wonderfulindonesia.adapter.ReviewAdapter

object ReviewData {

    private var listReview: ArrayList<Review> = arrayListOf(
        Review(
            "Udin Epul",
            5,
            "Bagus banget! Sangat menghibur apalagi tempatnya juga mendukung karena acaranya bisa sekalian lihat sunset."
        ),
        Review(
            "David Saepul",
            4,
            "so beautiful performance and view"
        ),
        Review(
            "Rafael Zay",
            5,
            "view cantik sekali, dan pertunjukan yg sangat menghibur. jangan terlalu dadakan, krn harus cr parkir dulu, antri beli tiket masuk jg. untung beli tiket online,jd dapat pertunjukan pertama walaupun datang mepet. thank u bali for this fantastic show n view"
        )
    )

    val listData: ArrayList<Review>
        get() = listReview



}