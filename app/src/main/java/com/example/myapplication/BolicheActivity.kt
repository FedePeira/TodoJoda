package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class BolicheActivity: AppCompatActivity() {

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
        navHostFragment.navController.setGraph(R.navigation.boliche_navgraph, bundle)

        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.bolicheDetailFragment || destination.id == R.id.bolicheOpinionsFragment) {
                appBarLayout.visibility = View.GONE
            } else {
                appBarLayout.visibility = View.VISIBLE
            }
        }

        bottomNavView = findViewById(R.id.bottomBar)
        bottomNavView.setOnNavigationItemSelectedListener   { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    val bundle = bundleOf("name" to name)
                    navHostFragment.navController.navigate(R.id.homeFragment, bundle)
                    true
                }
                R.id.profileActivity -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    intent.putExtra("name", name)
                    intent.putExtra("profileActivity", R.id.profileActivity)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
        userNameTextView.text = name
    }



}