package com.example.lifehackstudioapp.main_screen.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lifehackstudioapp.R
import com.example.lifehackstudioapp.databinding.FragmentMainScreenBinding


class MainScreenFragment : Fragment(R.layout.fragment_main_screen) {

    private val binding by viewBinding(FragmentMainScreenBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}