package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databaseBoliche.AppDatabase
import com.example.myapplication.databaseBoliche.BolicheDao
import com.example.myapplication.models.Boliche

class BolicheAdapter(private val ids: List<Int>) :
    RecyclerView.Adapter<BolicheViewHolder>() {

    // Variable Dao
    private lateinit var bolicheDao: BolicheDao

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): BolicheViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val id = ids[viewType]
        // Inicializamos AppDatabase
        val appDatabase = AppDatabase.getDatabase(parent.context)
        bolicheDao = appDatabase.BolicheDao()
        // Le pasamos Id al ViewHolder
        var bolicheViewHolder = BolicheViewHolder(layoutInflater.inflate(R.layout.item_boliche, parent, false), id = id)
        return bolicheViewHolder
    }

    override fun onBindViewHolder(holder: BolicheViewHolder, position: Int) {
        val id = ids[position]
        // Aquí necesitas obtener el Boliche correspondiente a este ID de tu base de datos
        val boliche = bolicheDao.getBolicheById(id)
        holder.render(boliche)
    }

    override fun getItemCount() = ids.size

    override fun getItemViewType(position: Int): Int {
        return position
    }
}