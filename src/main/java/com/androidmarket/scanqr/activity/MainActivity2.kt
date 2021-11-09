package com.androidmarket.scanqr.activity

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.androidmarket.scanqr.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main3)
        setUpNavigation();

//
//        val navView: BottomNavigationView = findViewById(R.id.nav_view)
//
//
//        navView.setOnNavigationItemReselectedListener {
//            when(it.itemId){
//
//            }
//        }
//
//        val navController = findNavController(R.id.nav_host_fragment)
////        setupBottomNavMenu(navController);
//
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_scan,R.id.navigation_create,R.id.navigation_history,R.id.navigation_setting
//            )
//        )
////        setupActionBarWithNavController(navController)
//        navView.setupWithNavController(navController)

    }

    fun setUpNavigation() {
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        NavigationUI.setupWithNavController(
            navView,
            navHostFragment!!.navController
        )
    }


//    private fun setupBottomNavMenu(navController: NavController) {
//        val bottomNav = findViewById<BottomNavigationView>(R.id.nav_view)
//        bottomNav?.setupWithNavController(navController)
//    }


}