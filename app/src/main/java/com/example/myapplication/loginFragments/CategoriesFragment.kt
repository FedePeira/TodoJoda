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

class CategoriesFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val v = inflater.inflate(R.layout.fragment_categories, container, false)
        val btn_category_boliche = v.findViewById<AppCompatButton>(R.id.categoryBoliche)
        val name = arguments?.getString("name")
        val action = CategoriesFragmentDirections.actionCategoriesFragmentToBolicheFragment(name.toString())
        btn_category_boliche.setOnClickListener {
            findNavController().navigate(action)
        }
        return v
    }
}