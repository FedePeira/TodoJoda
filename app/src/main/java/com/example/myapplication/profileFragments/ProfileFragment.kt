package com.example.myapplication.profileFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.google.gson.Gson

class ProfileFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_profile, container, false)
        val openActividad: ImageView = v.findViewById(R.id.openActividad)
        val openAyuda: ImageView = v.findViewById(R.id.openAyuda)
        val openDatosPersonales: ImageView = v.findViewById(R.id.openDatosPersonales)

        openActividad.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_profileActividadFragment)
        }
        openAyuda.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_profileAyuda)
        }
        openDatosPersonales.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_profileDatosPersonalesFragment)
        }
        return v
    }
}