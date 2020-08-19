package com.agesa.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_welcome.view.*


class WelcomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)
        view.findViewById<Button>(R.id.buttonLogin).setOnClickListener {
            val email = view.email.text.toString()
            val password = view.password.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {

                findNavController().navigate(R.id.action_welcomeFragment_to_registrationFragment)
            }
        }
        view.findViewById<Button>(R.id.btnRegister).setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_welcomeFragment_to_homeFragment)
        )
        return view
    }


}