package com.cherrio.playground.drawer.drawerfrags

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cherrio.playground.databinding.BottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/*
* Created by Ayodele on 26/06/2021
* Email: jazzedayo@gmail.com
* Abuja, NIGERIA
*/

class BottomSheet(val bttmDismiss: () -> Unit): BottomSheetDialogFragment() {

    lateinit var binding: BottomSheetBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDismiss(dialog: DialogInterface) {
        bttmDismiss()
        super.onDismiss(dialog)
    }



    companion object{
        const val TAG = "BOTTOM_SHEET"
    }
}