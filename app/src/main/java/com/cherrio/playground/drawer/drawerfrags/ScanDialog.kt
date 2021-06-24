package com.cherrio.playground.drawer.drawerfrags

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import com.cherrio.playground.R
import com.cherrio.playground.databinding.HomeDialogBinding

/*
* Created by Ayodele on 24/06/2021
* Email: jazzedayo@gmail.com
* Abuja, NIGERIA
*/

class ScanDialog: DialogFragment() {

    private lateinit var binding: HomeDialogBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            startActivityForResult(buildImageIntent(), IMAGE)
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = HomeDialogBinding.inflate(layoutInflater)
        val dialog = Dialog(requireContext(), R.style.DialogFragmentTheme)
        dialog.setContentView(binding.root)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }


    private fun buildImageIntent(): Intent {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        return intent
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }


    companion object{
        const val TAG = "DialogFragmentHome"
        const val IMAGE = 221
    }


}