package com.example.myapplication.adapter

import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class BolicheViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title: TextView = view.findViewById(R.id.itemTitle)
    val description: TextView = view.findViewById(R.id.itemDescription)
    val rating: RatingBar = view.findViewById(R.id.ratingBar)
}