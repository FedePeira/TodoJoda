package com.example.myapplication.loginFragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.BolicheActivity
import com.example.myapplication.LoginActivity
import com.example.myapplication.R

class RegisterFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_register, container, false)
        val button = v.findViewById<Button>(R.id.mainButton)
        button.setOnClickListener {
            val editTextname = v.findViewById<EditText>(R.id.editTextName)
            val name = editTextname.text.toString()
            val action = RegisterFragmentDirections.actionRegisterFragmentToCategoriesFragment(name)
            if (name.isEmpty()) {
                editTextname.setError("Este campo es obligatorio")
            } else {
                findNavController().navigate(action)
            }
        }
        return v
    }

}