package com.driskimaulana.wonderfulindonesia

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.driskimaulana.wonderfulindonesia.fragment.AboutFragment
import com.driskimaulana.wonderfulindonesia.fragment.FavoriteFragment
import com.driskimaulana.wonderfulindonesia.fragment.HomeFragment
import com.driskimaulana.wonderfulindonesia.model.ObjectWisata
import com.driskimaulana.wonderfulindonesia.utils.Utils
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navbar : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.green_primary)))
        initView()
        /*
        create utils object that will use for the entire application because it's a singleton class
         */
        Utils.getInstance(this)


        showHomeFragment()

        navbar.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.menu_favorite -> {
                    showFavoriteFragment()
                    true
                }
                R.id.menu_home -> {
                    showHomeFragment()
                    true
                }
                R.id.menu_about -> {
                    showAboutFragment()
                    true
                }
                else -> false

            }
        }

    }

    private fun showAboutFragment() {
        supportActionBar?.title = "About Me"

        val mFragment = supportFragmentManager

        val aboutFragment = AboutFragment()

        var fragment = mFragment.findFragmentByTag(AboutFragment::class.java.simpleName)

        if(fragment !is AboutFragment)
        {
            mFragment.beginTransaction()
                .replace(R.id.frame_activity, aboutFragment, AboutFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun showFavoriteFragment() {
        supportActionBar?.title = "Favorite Object Wisata"
        val mFragmentManager = supportFragmentManager

        val favoriteFragment = FavoriteFragment()

        var fragment =mFragmentManager.findFragmentByTag(FavoriteFragment::class.java.simpleName)

        if(fragment !is FavoriteFragment)
        {
            mFragmentManager.beginTransaction()
                .replace(R.id.frame_activity, favoriteFragment, FavoriteFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun showHomeFragment()
    {
        supportActionBar?.title = "List Object Wisata"
        val mFragmentManager = supportFragmentManager

        val homeFragment = HomeFragment()

        var fragment = mFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if(fragment !is HomeFragment)
        {
            mFragmentManager.beginTransaction()
                .replace(R.id.frame_activity, homeFragment, HomeFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun initView() {
        navbar = findViewById(R.id.navbar)
    }
}