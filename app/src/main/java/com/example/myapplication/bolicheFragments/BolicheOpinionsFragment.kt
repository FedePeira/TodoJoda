package com.example.myapplication.bolicheFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.BolicheOpinionAdapter
import com.example.myapplication.databaseBoliche.AppDatabase
import com.example.myapplication.databaseBoliche.BolicheDao
import com.example.myapplication.models.Boliche
import com.jakewharton.threetenabp.AndroidThreeTen

class BolicheOpinionsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: BolicheOpinionAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var appDatabase: AppDatabase
    private lateinit var bolicheDao: BolicheDao

    private var bolicheId: Int? = null
    private lateinit var boliche: Boliche


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidThreeTen.init(context)

        appDatabase = AppDatabase.getDatabase(requireContext())
        bolicheDao = appDatabase.BolicheDao()

        bolicheId = arguments?.getInt("bolicheId")
        boliche = bolicheDao.getBolicheById(bolicheId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_opinionsboliche, container, false)

        // RecyclerView
        recyclerView = v.findViewById(R.id.bolichesOpinionsRecycler)
        recyclerView.isNestedScrollingEnabled = true
        // RecyclerView Layout
        viewManager = LinearLayoutManager(context)

        // Initialize viewAdapter here with the list of Boliche
        viewAdapter = BolicheOpinionAdapter(boliche.opinions)

        // Set up RecyclerView
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
        return v
    }
}