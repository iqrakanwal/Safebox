package com.example.safebox

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.safebox.SharedPreferencesUtils.getMenuVisibility
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.secondScreenFragment -> {
                    // showToolbar()

                }
                R.id.listFragment -> {


                }
                R.id.mainscreen -> {
                    // hideToolbar()

                }
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.options_menu, menu)




        return true
    }


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
            R.id.signout -> {

                //   Toast.makeText(this, "fgdfg", Toast.LENGTH_SHORT).show()
                //item.onNavDestinationSelected(navController)
                true
            }
            R.id.manageafes -> {
                Log.e("fjkgjfg", "dsflksdfj")

                //navController.navigate(R.id.action_secondScreenFragment_to_listFragment)
                true
            }
            R.id.mainone -> {
                navController.navigate(R.id.action_mainscreen_to_secondScreenFragment)

                //   Toast.makeText(this, "fgdfg", Toast.LENGTH_SHORT).show()
                //item.onNavDestinationSelected(navController)
                true
            }
            R.id.mainscree2 -> {
                Log.e("fjkgjfg", "${navController.currentDestination?.displayName}")
               /* if (navController.currentDestination?.displayName=="id/secondScreenFragment"){
                    navController.navigate(R.id.action_secondScreenFragment_to_mainscreen)

                }else{
                    navController.navigate(R.id.action_mainscreen_to_secondScreenFragment)

                }*/
                true
            }
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
        menu.getItem(0).isVisible = getMenuVisibility(this)
        menu.getItem(1).isVisible = getMenuVisibility(this)
        return super.onPrepareOptionsMenu(menu)

    }
}