package com.example.myapplication.adapter

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.models.Boliche
import com.google.gson.Gson

class BolicheViewHolder(bolicheView: View, val id: Int) : RecyclerView.ViewHolder(bolicheView) {
    val title: TextView = bolicheView.findViewById(R.id.itemTitle)
    val description: TextView = bolicheView.findViewById(R.id.itemDescription)
    val rating: RatingBar = bolicheView.findViewById(R.id.ratingBar)
    val ratingCount: TextView = bolicheView.findViewById(R.id.ratingCount)
    val openDetail: ImageView = bolicheView.findViewById(R.id.openDetail)

    private lateinit var boliche: Boliche

    init {
        openDetail.setOnClickListener {
            val bolicheJsonString = Gson().toJson(boliche).toString()

            val bundle = bundleOf("boliche" to bolicheJsonString, "id" to id)
            it.findNavController().navigate(R.id.action_bolicheHomeFragment_to_bolicheDetailFragment, bundle)
        }
    }

    fun render(bolicheModel: Boliche) {
        boliche = bolicheModel
        title.text = bolicheModel.title
        description.text = bolicheModel.description
        rating.setRating(bolicheModel.rating.toFloat())
        ratingCount.text = bolicheModel.rating.toString()
    }

}