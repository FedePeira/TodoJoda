package com.example.myapplication.adapter

import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.models.Opinion

class BolicheOpinionViewHolder(opinionView: View) : RecyclerView.ViewHolder(opinionView) {
    val userNameOpinion: TextView = itemView.findViewById(R.id.userNameOpinion)
    val ratingBarOpinion: RatingBar = itemView.findViewById(R.id.ratingBarOpinion)
    val titleOpinion: TextView = itemView.findViewById(R.id.titleOpinion)
    val descriptionOpinion: TextView = itemView.findViewById(R.id.descriptionOpinion)

    fun render(opinionModel: Opinion) {
        userNameOpinion.text = opinionModel.person
        ratingBarOpinion.rating = opinionModel.rating.toFloat()
        titleOpinion.text = opinionModel.title
        descriptionOpinion.text = opinionModel.description
    }
}