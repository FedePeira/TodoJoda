package com.example.myapplication.bolicheFragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.BolicheAdapter
import com.example.myapplication.databaseBoliche.AppDatabase
import com.example.myapplication.databaseBoliche.BolicheDao
import com.example.myapplication.models.Boliche
import com.example.myapplication.models.Opinion
import com.jakewharton.threetenabp.AndroidThreeTen
import org.threeten.bp.LocalTime

@Suppress("DEPRECATION")
class BolicheHomeFragment: Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: BolicheAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var appDatabase: AppDatabase
    private lateinit var bolicheDao: BolicheDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidThreeTen.init(context)

        appDatabase = AppDatabase.getDatabase(requireContext())
        bolicheDao = appDatabase.BolicheDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_homeboliche, container, false)

        // RecyclerView
        recyclerView = v.findViewById(R.id.bolichesListRecycler)
        recyclerView.isNestedScrollingEnabled = true
        // RecyclerView Layout
        viewManager = LinearLayoutManager(context)

        // Loading Animation
        val loadingRecyclerView = v.findViewById<ImageView>(R.id.loadingRecyclerView)
        val rotateAnimation = AnimationUtils.loadAnimation(context, R.anim.rotate_big_loading)
        val bolichesIds = mutableListOf<Int>()
        val boliches = mutableListOf<Boliche>()

        // Show animation
        loadingRecyclerView.visibility = View.VISIBLE
        loadingRecyclerView.startAnimation(rotateAnimation)

        // Opiniones de Boliches
        val boliche1 = Boliche(
            id = 1,
            title = "Boliche A",
            description = "Este es el boliche A",
            rating = 4,
            location = "Calle 123",
            timeOpen = LocalTime.of(20, 0),
            timeClose = LocalTime.of(4, 0),
            celNumber = "1234567890",
            linkWebsite = "www.bolicheA.com"
        )

        val boliche2 = Boliche(
            id = 2,
            title = "Boliche B",
            description = "Este es el boliche B",
            rating = 5,
            location = "Avenida 456",
            timeOpen = LocalTime.of(21, 0),
            timeClose = LocalTime.of(5, 0),
            celNumber = "0987654321",
            linkWebsite = "www.bolicheB.com"
        )

        val opinion1 = Opinion(
            person = "Javier",
            rating = 4,
            title = "Muy Bueno el Boliche",
            description = "Increible lugar, con gente muy amable, la musica muy buena con un ambiente muy bien diseñado"
        )

        val opinion3 = Opinion(
            person = "Roberto",
            rating = 4,
            title = "Muy Bueno el Boliche",
            description = "Increible lugar, con gente muy amable, la musica muy buena con un ambiente muy bien diseñado"
        )

        val opinion4 = Opinion(
            person = "Alejandro",
            rating = 4,
            title = "Muy Bueno el Boliche",
            description = "Increible lugar, con gente muy amable, la musica muy buena con un ambiente muy bien diseñado"
        )

        val opinion2 = Opinion(
            person = "Roberto",
            rating = 2,
            title = "Muy Malo el Boliche",
            description = "Malo el lugar, con gente poco amable, la musica  buena con un ambiente mal diseñado"
        )

        // Agregar datos a las listas
        boliche1.stats.add("Estadística 1")
        boliche1.opinions.add(opinion1)
        boliche1.opinions.add(opinion3)
        boliche1.opinions.add(opinion4)
        boliche1.images.add("samsara_image")

        boliche2.stats.add("Estadística 2")
        boliche2.opinions.add(opinion2)
        boliche2.images.add("samsara_image")

        boliches.add(boliche1)
        boliches.add(boliche2)
        bolichesIds.add(boliche1.id!!)
        bolichesIds.add(boliche2.id!!)

        Handler().postDelayed({
            // Load data here...
            // Initialize viewAdapter here with the list of Boliche
            viewAdapter = BolicheAdapter(bolichesIds)

            // Set up RecyclerView
            recyclerView.apply {
                setHasFixedSize(true)
                layoutManager = viewManager
                adapter = viewAdapter
            }
            // Hide
            loadingRecyclerView.clearAnimation()
            loadingRecyclerView.visibility = View.GONE
        }, 2000)

        // Insert the boliches into the database
        boliches.forEach { boliche ->
            bolicheDao.insertBoliche(boliche)
        }
        return v
    }

}