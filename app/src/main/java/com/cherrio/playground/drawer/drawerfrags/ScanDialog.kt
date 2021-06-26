package com.cherrio.playground.drawer.drawerfrags

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.DialogFragment
import com.cherrio.playground.R
import com.cherrio.playground.databinding.HomeDialogBinding

/**
* Created by Ayodele on 24/06/2021
* Email: jazzedayo@gmail.com
* Abuja, NIGERIA
*/

class ScanDialog(val dismissed: () -> Unit): DialogFragment() {

    private lateinit var binding: HomeDialogBinding
    private lateinit var sheet: BottomSheet

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        log("onViewCreated")
        binding.button.setOnClickListener {
            dismissAllowingStateLoss()
        }

        binding.editTextTextPersonName.typing {
            println("Typing: $it")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = HomeDialogBinding.inflate(layoutInflater)
        val dialog = Dialog(requireContext(), R.style.DialogFragmentTheme)
        dialog.setContentView(binding.root)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        onViewCreated(binding.root, savedInstanceState)
        openSheet()
        return dialog
    }

    private fun openSheet(){
         sheet = BottomSheet{
            println("Bottom Sheet Dismissed")
        }
        sheet.show(childFragmentManager, BottomSheet.TAG)
    }




    private fun buildImageIntent(): Intent {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        return intent
    }



    companion object{
        const val TAG = "DialogFragmentHome"
        const val IMAGE = 221
    }

   private fun EditText.typing(typing: (Boolean) -> Unit){
        doAfterTextChanged {text ->
            typing.invoke(true)
            val textLength = text?.length
            Handler(Looper.getMainLooper()).postDelayed({
                if (textLength == text?.length){
                    typing.invoke(false)
                }
            },2000)
        }
    }
    fun log(message: String){
        Log.d(TAG, message)
    }

    override fun onDismiss(dialog: DialogInterface) {
        sheet.dismissAllowingStateLoss()
        dismissed()
        super.onDismiss(dialog)
    }




}