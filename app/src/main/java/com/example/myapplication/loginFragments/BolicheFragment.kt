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

class BolicheFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_boliche, container, false)
        val btn_home_boliche = v.findViewById<AppCompatButton>(R.id.bolicheBoliches)
        val name = arguments?.getString("name")
        btn_home_boliche.setOnClickListener {
            val intent = Intent(requireContext(), BolicheActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        }
        return v
    }
}