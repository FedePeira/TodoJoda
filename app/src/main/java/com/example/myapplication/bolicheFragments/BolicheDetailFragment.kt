package com.example.myapplication.bolicheFragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.example.myapplication.adapter.BolicheViewHolder
import com.example.myapplication.adapter.BolicheImageAdapter
import com.example.myapplication.models.Boliche
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.gson.Gson
import org.threeten.bp.LocalTime


private const val ARG_BOLICHE = "boliche"

class BolicheDetailFragment : Fragment() {
    private lateinit var boliche: Boliche
    private var id: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            boliche = Gson().fromJson(it.getString(ARG_BOLICHE), Boliche::class.java)
            id = it.getInt("id")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detailboliche, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPagerImage = view.findViewById<ViewPager2>(R.id.viewPager)
        val bolicheName = view.findViewById<TextView>(R.id.bolicheName)
        val bolicheLocation = view.findViewById<TextView>(R.id.bolicheLocation)
        val statsLayout = view.findViewById<LinearLayout>(R.id.detailDescriptionStats)
        val scheduleStatus = view.findViewById<TextView>(R.id.scheduleStatus)
        val schedule = view.findViewById<TextView>(R.id.schedule)
        val websiteTextView = view.findViewById<TextView>(R.id.website)
        val opineButton = view.findViewById<AppCompatButton>(R.id.opineButton)
        val opinionsButton = view.findViewById<AppCompatButton>(R.id.opinionsButton)

        bolicheName.text = boliche.title
        bolicheLocation.text = boliche.location

        boliche.stats.forEach { stat ->
            val textView = TextView(context).apply {
                text = stat
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                // Chequear size
                textSize = 16f
                setTextColor(ContextCompat.getColor(context, R.color.text))

                typeface = ResourcesCompat.getFont(context, R.font.poppins_regular)
            }
            statsLayout.addView(textView)
        }

        val now = LocalTime.now()

        if (now.isAfter(boliche.timeOpen) && now.isBefore(boliche.timeClose)) {
            // El boliche está abierto
            scheduleStatus.text = "Abierto ahora"
            scheduleStatus.setTextColor(ContextCompat.getColor(context?: return, R.color.correct)) // Reemplaza 'verde' con el nombre de tu color verde
        } else {
            // El boliche está cerrado
            scheduleStatus.text = "Cerrado por ahora"
            scheduleStatus.setTextColor(ContextCompat.getColor(context?: return, R.color.error)) // Reemplaza 'rojo' con el nombre de tu color rojo
        }

        schedule.text = "De " + boliche.timeOpen + " a " + boliche.timeClose

        websiteTextView.setOnClickListener {
            val url = boliche.linkWebsite
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        opineButton.setOnClickListener {
            findNavController().navigate(R.id.action_bolicheDetailFragment_to_opineFragment)
        }

        opinionsButton.setOnClickListener {
            findNavController().navigate(R.id.action_bolicheDetailFragment_to_opinionsFragment)
        }

        viewPagerImage.adapter = BolicheImageAdapter(boliche.images, context)

    }

    /*
    companion object {
        @JvmStatic
        fun newInstance(dogJson: String) =
            DogDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_DOG, dogJson)
                    putString("username", username)
                }
            }
    }
     */
}