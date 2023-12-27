package com.example.myapplication.loginFragments

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.myapplication.BolicheActivity
import com.example.myapplication.R

class CategoriesFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val v = inflater.inflate(R.layout.fragment_categories, container, false)
        val categoryBoliche = v.findViewById<AppCompatButton>(R.id.categoryBoliche)
        val categoryAmigos = v.findViewById<AppCompatButton>(R.id.categoryAmigos)
        val categoryPrevia = v.findViewById<AppCompatButton>(R.id.categoryPrevia)
        val categoryEncuentros = v.findViewById<AppCompatButton>(R.id.categoryEncuentros)
        val categoryRestaurante = v.findViewById<AppCompatButton>(R.id.categoryRestaurante)
        val categoryPlaya = v.findViewById<AppCompatButton>(R.id.categoryPlaya)
        val name = arguments?.getString("name")
        val actionBoliche = CategoriesFragmentDirections.actionCategoriesFragmentToBolicheFragment(name.toString())

        setupButton(categoryBoliche, actionBoliche)
        setupButton(categoryAmigos, actionBoliche)
        setupButton(categoryPrevia, actionBoliche)
        setupButton(categoryEncuentros, actionBoliche)
        setupButton(categoryRestaurante, actionBoliche)
        setupButton(categoryPlaya, actionBoliche)

        return v
    }

    private fun setupButton(button: AppCompatButton, action: NavDirections) {
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

                    // Navigate to the next fragment
                    findNavController().navigate(action)
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