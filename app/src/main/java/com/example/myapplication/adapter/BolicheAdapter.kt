package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.models.Boliche

class BolicheAdapter(private val myDataset: List<Boliche>) :
    RecyclerView.Adapter<BolicheViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): BolicheViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_boliche, parent, false)
        return BolicheViewHolder(view)
    }

    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onBindViewHolder(holder: BolicheViewHolder, position: Int) {
        val boliche = myDataset[position]
        holder.title.text = boliche.title
        holder.description.text = boliche.description
        holder.rating.text = boliche.rating.toString()
    }

    override fun getItemCount() = myDataset.size
}