package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var bottomNavView: BottomNavigationView

    companion object {
        fun getNavController(context: Context): NavController {
            val navHostFragment = (context as BolicheActivity).supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
            return navHostFragment.navController
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boliche)

        val appBarLayout: View = findViewById(R.id.appBarMain)
        val userNameTextView = appBarLayout.findViewById<TextView>(R.id.userName)

        val name = intent.getStringExtra("name")

        val bundle = bundleOf("username" to name!!)

        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val appBarProfile = inflater.inflate(R.layout.app_bar_profile, null)

        // Replace the current appBarMain with appBarProfile
        val parent = appBarLayout.parent as ViewGroup
        parent.removeView(appBarLayout)
        parent.addView(appBarProfile)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        navHostFragment.navController.setGraph(R.navigation.profile_navgraph, bundle)
        bottomNavView = findViewById(R.id.bottomBar)
        val selectedItemId = intent.getIntExtra("profileActivity", R.id.profileActivity)
        bottomNavView.selectedItemId = selectedItemId
        userNameTextView.text = name
    }


}