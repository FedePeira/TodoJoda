package com.example.myapplication.loginFragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.myapplication.BolicheActivity
import com.example.myapplication.R

class BolicheFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_boliche, container, false)
        val bolichePassline = v.findViewById<AppCompatButton>(R.id.bolichePassline)
        val bolicheBoliches = v.findViewById<AppCompatButton>(R.id.bolicheBoliches)
        val bolicheWhatsapp = v.findViewById<AppCompatButton>(R.id.bolicheWhatsapp)
        val name = arguments?.getString("name")
        val intentBoliches = Intent(requireContext(), BolicheActivity::class.java)

        intentBoliches.putExtra("name", name)

        setupButton(bolichePassline, intentBoliches)
        setupButton(bolicheBoliches, intentBoliches)
        setupButton(bolicheWhatsapp, intentBoliches)


        return v
    }

    private fun setupButton(button: AppCompatButton, intent: Intent) {
        button.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Change the button properties to simulate "hover" effect
                    button.scaleX = 1.2f
                    button.scaleY = 1.2f
                    true
                }
                MotionEvent.ACTION_UP -> {
                    // Revert the changes when the user stops touching the button
                    button.scaleX = 1f
                    button.scaleY = 1f
                    button.backgroundTintList = null

                    // Start the activity
                    startActivity(intent)
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    // Revert the changes when the touch is cancelled
                    button.scaleX = 1f
                    button.scaleY = 1f
                    button.backgroundTintList = null
                    true
                }
                else -> false
            }
        }
    }
}