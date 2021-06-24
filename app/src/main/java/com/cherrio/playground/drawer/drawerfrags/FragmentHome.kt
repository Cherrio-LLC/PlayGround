package com.cherrio.playground.drawer.drawerfrags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cherrio.playground.databinding.FragmentDrawerHomeBinding

/*
* Created by Ayodele on 24/06/2021
* Email: jazzedayo@gmail.com
* Abuja, NIGERIA
*/

class FragmentHome: Fragment() {

    private lateinit var binding: FragmentDrawerHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrawerHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openDialog()
    }

    private fun openDialog(){
        val dialog = ScanDialog()
        dialog.show(childFragmentManager,ScanDialog.TAG)
    }
}