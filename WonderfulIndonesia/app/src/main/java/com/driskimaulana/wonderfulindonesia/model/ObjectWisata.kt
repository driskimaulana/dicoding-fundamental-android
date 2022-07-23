package com.driskimaulana.wonderfulindonesia.model

import android.media.Rating
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ObjectWisata(

    var idObjectWisata: Int = 0,
    var name: String = "",
    var location: String = "",
    var description: String = "",
    var imageCover: Int = 0,
    var ticket: Int = 0,
    var rating: Double = 0.0,
    var isFavorite: Boolean = false,
    var openSchedule: String = "",
    var gallery: IntArray

) : Parcelable
