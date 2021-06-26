package com.cherrio.playground.drawer.drawerfrags

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.cherrio.playground.R
import com.cherrio.playground.databinding.HybridDialogBinding

/*
* Created by Ayodele on 26/06/2021
* Email: jazzedayo@gmail.com
* Abuja, NIGERIA
*/

/**
 * This is the hybrid dialogfragment that houses the bottomsheet and dialog
 * Notice the function dismissed that i passed into the constructor, its like a callback
 * when the dialog has been dismissed and you can do what you want
 */

class HybridDialogSheet(val dismissed: () -> Unit): DialogFragment() {

    private lateinit var binding: HybridDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME,R.style.DialogFragmentTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HybridDialogBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.dialog.button.setOnClickListener {
            dismissAllowingStateLoss()
        }
    }


    override fun onDismiss(dialog: DialogInterface) {
        dismissed()
        super.onDismiss(dialog)
    }

}