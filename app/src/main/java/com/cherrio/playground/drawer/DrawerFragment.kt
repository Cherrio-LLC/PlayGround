package com.cherrio.playground.drawer

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.findFragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.cherrio.playground.R
import com.cherrio.playground.databinding.FragmentDrawerBinding

/*
* Created by Ayodele on 24/06/2021
* Email: jazzedayo@gmail.com
* Abuja, NIGERIA
*/

class DrawerFragment: Fragment() {

    private lateinit var binding: FragmentDrawerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDrawerBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            burgerBtn.setOnClickListener {
                if (!drawerLayout.isDrawerOpen(GravityCompat.START)) drawerLayout.openDrawer(GravityCompat.START)
                else drawerLayout.closeDrawer(GravityCompat.START)
            }
            val navhost = childFragmentManager.findFragmentById(R.id.drawer_nav_graph) as? NavHostFragment
            val controller = navhost?.navController
            navView.setupWithNavController(controller!!)
        }
    }
}