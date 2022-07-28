package com.driskimaulana.mynavigation

import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.drawerlayout.widget.DrawerLayout

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController : NavController
    private lateinit var appBarConfig: AppBarConfiguration
    private lateinit var drawer: DrawerLayout
    private lateinit var navigationView: NavigationView

    private lateinit var listener: NavController.OnDestinationChangedListener

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.let { it -> it.navController }
        drawer = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)

        navigationView.setupWithNavController(navController)

//        create connection between side appbar menu with navController graph which is provide navigate function
        appBarConfig = AppBarConfiguration(navController.graph, drawer)

//        add three strip menu icon
        setupActionBarWithNavController(navController, appBarConfig)

        listener = NavController.OnDestinationChangedListener { controller, destination, arguments ->
            if(destination.id == R.id.firstFragment)
            {
                supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.purple_500)))
            }else if(destination.id == R.id.secondFragment)
            {
                supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.teal_200)))
            }
        }

    }

    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(listener)
    }

    override fun onPause() {
        super.onPause()
        navController.addOnDestinationChangedListener(listener)
    }

    override fun onSupportNavigateUp(): Boolean {

        val navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.let { it -> it.navController }

        return navController.navigateUp(appBarConfig) || super.onSupportNavigateUp()

    }
}