package com.example.listfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class DialogFragment : DialogFragment() {

    lateinit var email: EditText
    lateinit var pwd: EditText
    lateinit var save: Button
    lateinit var cancel: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_dialog, container, false)
        email = view.findViewById(R.id.etEmail)
        pwd = view.findViewById(R.id.etPwd)
        save = view.findViewById(R.id.btnSave)
        cancel = view.findViewById(R.id.btnCancel)

        // make border of dialog box transparent
        // add !! for non null assert
        dialog!!.window!!.setBackgroundDrawableResource(android.R.color.transparent)

        // save on click
        save.setOnClickListener {

            // getting user data
            val userName: String = email.text.toString()
            val userPwd: Long = pwd.text.toString().toLong()

            // object to access main activity fun
            val mainActivity: MainActivity = activity as MainActivity
            mainActivity.getUserData(userName, userPwd)

            // close dialog
            dialog!!.dismiss()
        }

        // cancel on click
        cancel.setOnClickListener {
            dialog!!.dismiss()
        }

        // Inflate the layout for this fragment
        return view
    }
}