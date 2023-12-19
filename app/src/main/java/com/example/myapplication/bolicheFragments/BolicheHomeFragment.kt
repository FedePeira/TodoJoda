package com.example.myapplication.bolicheFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.BolicheAdapter
import com.example.myapplication.models.Boliche
import com.jakewharton.threetenabp.AndroidThreeTen
import org.threeten.bp.LocalTime

class BolicheHomeFragment: Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidThreeTen.init(context)
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

        // Opiniones de Boliches
        val opiniones = arrayListOf<String>()
        opiniones.add("Opinion 1")
        opiniones.add("Opinion 2")

        // DATASET Boliches
        val boliches = listOf(
            Boliche("Samsara Beach", "Bar y Boliche", 5,"Playa Grande sobre la Playa", LocalTime.of(18,0), LocalTime.of(5,0),"1136278965","https://federicopeirano.netlify.app/", opiniones),
            Boliche("Club Quba", "Bar y Boliche", 5,"Playa Grande sobre la Playa", LocalTime.of(18,0), LocalTime.of(5,0),"1136278965","https://federicopeirano.netlify.app/", opiniones),
            Boliche("Anana", "Bar y Boliche", 5,"Playa Grande sobre la Playa", LocalTime.of(18,0), LocalTime.of(5,0),"1136278965","https://federicopeirano.netlify.app/", opiniones),
            Boliche("El Container", "Bar y Boliche", 5,"Playa Grande sobre la Playa", LocalTime.of(18,0), LocalTime.of(5,0),"1136278965","https://federicopeirano.netlify.app/", opiniones),
            Boliche("Bruto Playa Grande", "Bar y Boliche", 5,"Playa Grande sobre la Playa", LocalTime.of(18,0), LocalTime.of(5,0),"1136278965","https://federicopeirano.netlify.app/", opiniones),
            Boliche("Sunset", "Bar y Boliche", 5,"Playa Grande sobre la Playa", LocalTime.of(18,0), LocalTime.of(5,0),"1136278965","https://federicopeirano.netlify.app/", opiniones),
            )

        // RecyclerView Layout
        viewManager = LinearLayoutManager(context)
        // Le pasamos el DATASET al Adapter
        viewAdapter = BolicheAdapter(boliches)

        // Le aplicaciomos al recyclerView el Adaptar y el Layout
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
        return v
    }
}