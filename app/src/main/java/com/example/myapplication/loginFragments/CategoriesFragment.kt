package com.example.myapplication.loginFragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.BolicheActivity
import com.example.myapplication.R
import setHoverEffect

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
        val action = CategoriesFragmentDirections.actionCategoriesFragmentToBolicheFragment(name.toString())

        categoryBoliche.setOnClickListener {
            findNavController().navigate(action)
        }

        // Animations
        categoryBoliche.setHoverEffect()
        categoryAmigos.setHoverEffect()
        categoryPrevia.setHoverEffect()
        categoryEncuentros.setHoverEffect()
        categoryRestaurante.setHoverEffect()
        categoryPlaya.setHoverEffect()

        return v
    }
}