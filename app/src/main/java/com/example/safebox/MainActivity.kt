package com.example.safebox

import android.graphics.Color
import android.graphics.Color.green
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.title=""

        setSupportActionBar(toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.secondScreenFragment -> {
                    // showToolbar()
                    toolbar.title="Main Screen 2"
                    toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                    invalidateOptionsMenu()
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        val window = window
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                        window.statusBarColor = ContextCompat.getColor(this, R.color.green)
                    }
                    //setToolbarIcon()
                }
                R.id.listFragment -> {
                    toolbar.title="Manage Safes"
                    toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                    invalidateOptionsMenu()
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        val window = window
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                        window.statusBarColor = ContextCompat.getColor(this, R.color.green)
                    }

                }
                R.id.connectScreenFragment -> {
                    toolbar.title="Connect"
                    toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                    invalidateOptionsMenu()
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        val window = window
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                        window.statusBarColor = ContextCompat.getColor(this, R.color.green)
                    }

                }
                R.id.mainscreen -> {
                    // hideToolbar()
                    toolbar.title="Main Screen 1"
                    toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.red))

                    invalidateOptionsMenu()
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        val window = window
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                        window.statusBarColor = ContextCompat.getColor(this, R.color.red)
                    }
                }
            }
        }

    }

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.options_menu, menu)

        return true
    }*/


    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        *//* val menuItem = menu.findItem(R.id.navigation_water)
         val actionView: View = menuItem.actionView
         tvItemBadge = actionView.findViewById(R.id.item_badge_text)
         if (!waterList.isNullOrEmpty()) {
             setupBadge(waterList[currentWaterDayPos].totalGlassOfWater)
         }
         actionView.setOnClickListener { onOptionsItemSelected(menuItem) }*//*
        return true
    }*/

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
         /*   R.id.mainscree1 -> {


                Log.e("fhkdsf", "${navController.currentDestination?.displayName}")
                if (navController.currentDestination?.displayName == "com.example.safebox:id/mainscreen") {
                    Toast.makeText(this, "kdfjdfj", Toast.LENGTH_LONG).show()

                } else {
                    navController.navigate(R.id.action_secondScreenFragment_to_mainscreen)
                }

                true
            }*/



            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun hideToolbar() {

        if (toolbar.isVisible)
            toolbar.visibility = View.GONE
    }

    fun showToolbar() {

        if (!toolbar.isVisible) {
            toolbar.visibility = View.VISIBLE
        }


    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
     //   menu.getItem(0).isVisible = getMenuVisibility(this)
        return super.onPrepareOptionsMenu(menu)

    }

    override fun onBackPressed() {
        finish()
    }
}