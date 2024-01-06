package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boliche)

        val appBarLayout: View = findViewById(R.id.appBarMain)
        val userNameTextView = appBarLayout.findViewById<TextView>(R.id.userName)

        val name = intent.getStringExtra("name")

        val bundle = bundleOf("username" to name!!)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        navHostFragment.navController.setGraph(R.navigation.profile_navgraph, bundle)
        bottomNavView = findViewById(R.id.bottomBar)
        val selectedItemId = intent.getIntExtra("profileActivity", R.id.profileActivity)
        bottomNavView.selectedItemId = selectedItemId

        userNameTextView.text = name
    }
}