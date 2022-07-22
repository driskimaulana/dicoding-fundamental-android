package com.driskimaulana.wonderfulindonesia

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.driskimaulana.wonderfulindonesia.fragment.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navbar : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.green_primary)))
        initView()

        showHomeFragment()

        navbar.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.menu_favorite -> {
                    Toast.makeText(this, "Favorite Active", Toast.LENGTH_SHORT)
                    true
                }
                R.id.menu_home -> {
                    Toast.makeText(this, "Home Selected", Toast.LENGTH_SHORT)
                    true
                }
                R.id.menu_about -> {
                    Toast.makeText(this, "About Selected", Toast.LENGTH_SHORT)
                    true
                }
                else -> false

            }
        }

    }

    private fun showHomeFragment()
    {
        supportActionBar?.title = "List Object Wisata"
        val mFragmentManager = supportFragmentManager

        val homeFragment = HomeFragment()

        var fragment =mFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if(fragment !is HomeFragment)
        {
            mFragmentManager.beginTransaction()
                .add(R.id.frame_activity, homeFragment, HomeFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun initView() {
        navbar = findViewById(R.id.navbar)
    }
}