package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class BolicheActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boliche)

        val appBarLayout = findViewById<View>(R.id.appBarMain)
        val userNameTextView = appBarLayout.findViewById<TextView>(R.id.userName)

        val userName = intent.getStringExtra("userName")
        userNameTextView.text = userName
    }



}