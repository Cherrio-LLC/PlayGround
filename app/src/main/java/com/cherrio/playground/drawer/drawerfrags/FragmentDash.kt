package com.cherrio.playground.drawer.drawerfrags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cherrio.playground.databinding.FragmentDrawerDashBinding

/*
* Created by Ayodele on 24/06/2021
* Email: jazzedayo@gmail.com
* Abuja, NIGERIA
*/

class FragmentDash: Fragment() {

    private lateinit var binding: FragmentDrawerDashBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrawerDashBinding.inflate(inflater)
        return binding.root
    }

}