package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.models.Opinion

class BolicheOpinionAdapter(private val opinions: List<Opinion>) :
    RecyclerView.Adapter<BolicheOpinionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BolicheOpinionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_opinionboliche, parent, false)
        return BolicheOpinionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return opinions.size
    }

    override fun onBindViewHolder(holder: BolicheOpinionViewHolder, position: Int) {
        val opinion = opinions[position]
        holder.render(opinion)
    }

}