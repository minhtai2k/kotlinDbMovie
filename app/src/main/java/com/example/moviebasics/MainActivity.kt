package com.example.moviebasics

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_main) as NavHostFragment
        navController = navHostFragment.navController

//        val appBarConfiguration = AppBarConfiguration(
//            topLevelDestinationIds = setOf(),
//            fallbackOnNavigateUpListener = ::onSupportNavigateUp
//        )
//        findViewById<Toolbar>(R.id.toolbar)
//            .setupWithNavController(navController, appBarConfiguration)

//        supportActionBar?.setDisplayShowHomeEnabled(true)
//        supportActionBar?.setLogo(R.drawable.ic_android_icon_home)
//        supportActionBar?.setDisplayUseLogoEnabled(false)
//
//        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        supportActionBar?.setDisplayShowCustomEnabled(true);
//

//        supportActionBar?.setCustomView(R.layout.)
//        supportActionBar?.setBackgroundDrawable(ColorDrawable(getResources().getColor(android.R.color.transparent)));


//        setupActionBarWithNavController(navController)

    }

    //    Setup menu icon actionbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_action_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_search_action_bar -> {
                searchItemTool()
                true
            }
            R.id.item_notification_action_bar -> {
                notificationItemTool()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun searchItemTool() {
//        findNavController().navigate()
        Toast.makeText(this, "You clicked Search Icon", Toast.LENGTH_SHORT).show()
    }

    private fun notificationItemTool() {
        Toast.makeText(this, "You clicked Notification Icon", Toast.LENGTH_SHORT).show()
    }

}