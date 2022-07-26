package com.driskimaulana.wonderfulindonesia.utils

import android.content.Context
import android.content.SharedPreferences
import com.driskimaulana.wonderfulindonesia.model.ObjectWisata
import com.driskimaulana.wonderfulindonesia.model.ObjectWisataData
import com.driskimaulana.wonderfulindonesia.utils.Constants
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Utils private constructor(context: Context) {
    private val sharedPreferences: SharedPreferences
    fun initData() {

        val objectWisatas: ArrayList<ObjectWisata> = ObjectWisataData.listData

        val editor = sharedPreferences.edit()
        val gson = Gson()
        editor.putString(Constants.ALL_OBJECT_WISATA_KEY, gson.toJson(objectWisatas))
        editor.commit()
    }

    //        get type of destination of deserialization which is type of ArrayList<ObjectWisata>
    val allObjectWisata: ArrayList

//        get allobjectwisata from sharedPreferences using gson
    <ObjectWisata>?
        get() {
            val gson = Gson()

            //        get type of destination of deserialization which is type of ArrayList<ObjectWisata>
            val type =
                object : TypeToken<ArrayList<ObjectWisata?>?>() {}.type

            //        get allobjectwisata from sharedPreferences using gson
            return gson.fromJson<ArrayList<ObjectWisata>>(
                sharedPreferences.getString(Constants.ALL_OBJECT_WISATA_KEY, null),
                type
            )
        }

    val favoriteObjectWisata: ArrayList<ObjectWisata>?
        get() {
            val gson = Gson()
            val type =
                object : TypeToken<ArrayList<ObjectWisata?>?>() {}.type
            return gson.fromJson<ArrayList<ObjectWisata>>(
                sharedPreferences.getString(
                    Constants.FAVORITE_OBJECT_WISATA_KEY,
                    null
                ), type
            )
        }


    fun getObjectWisataById(objectWisataId: Int): ObjectWisata? {
        if (null != allObjectWisata) {
            val objectWisatas: ArrayList<ObjectWisata>? = allObjectWisata
            if (objectWisatas != null) {
                for (b in objectWisatas) {
                    if (objectWisataId == b.idObjectWisata) return b
                }
            }
        }
        return null
    }

    fun addFavoriteObjectWisata(objectWisata: ObjectWisata): Boolean {
        val favoriteObjectWisatas: ArrayList<ObjectWisata>? = favoriteObjectWisata
        if (favoriteObjectWisatas != null) {
            if (favoriteObjectWisatas.add(objectWisata)) {
//        commit data changes to sharedpreferences
                val editor = sharedPreferences.edit()
                val gson = Gson()
                editor.remove(Constants.FAVORITE_OBJECT_WISATA_KEY)
                editor.putString(Constants.FAVORITE_OBJECT_WISATA_KEY, gson.toJson(favoriteObjectWisatas))
                editor.commit()
                return true
            }
        }
        return false
    }


    fun deleteFromFavoriteObjectWisata(objectWisata: ObjectWisata): Boolean {
        val objectWisatas: ArrayList<ObjectWisata>? = favoriteObjectWisata
        if (null != objectWisatas) {
            for (b in objectWisatas) {
                if (b.idObjectWisata === objectWisata.idObjectWisata) {
                    if (objectWisatas.remove(b)) {
                        val gson = Gson()
                        val editor = sharedPreferences.edit()
                        editor.putString(Constants.FAVORITE_OBJECT_WISATA_KEY, gson.toJson(objectWisatas))
                        editor.commit()
                        return true
                    }
                }
            }
        }
        return false
    }

    companion object {
        private var instance: Utils? = null
        fun getInstance(context: Context?): Utils? {
            return if (instance == null) {
                instance = context?.let { Utils(it) }
                instance
            } else {
                instance
            }
        }
    }

    init {
        sharedPreferences = context.getSharedPreferences("alternate_db", Context.MODE_PRIVATE)
        if (null == allObjectWisata) {
            initData()
        }
        val editor = sharedPreferences.edit()
        val gson = Gson()
        if (null == favoriteObjectWisata) {
            editor.putString(Constants.FAVORITE_OBJECT_WISATA_KEY, gson.toJson(ArrayList<ObjectWisata>()))
            editor.commit()
        }
    }
}