package com.example.listfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    lateinit var btnReplace: Button
    lateinit var btnDialog: Button
    lateinit var name: TextView
    lateinit var pwd: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnReplace = findViewById(R.id.btnReplace)
        btnDialog = findViewById(R.id.btnDialog)
        name = findViewById(R.id.tvUsername)
        pwd = findViewById(R.id.tvPassword)

        // first fragment by default
        val firstFragmentManager : FragmentManager = supportFragmentManager
        val firstFragmentTransaction: FragmentTransaction = firstFragmentManager.beginTransaction()

        // object of fragment class
        val firstFragment = FirstFragment()
        // 2 params: layout id of main.xml & object of fragment class
        // use add method to add fragment
        firstFragmentTransaction.add(R.id.frame, firstFragment)
        firstFragmentTransaction.commit()

//         replace fragment on button click
        btnReplace.setOnClickListener {
            val secondFragmentManager: FragmentManager = supportFragmentManager
            val secondFragmentTransaction: FragmentTransaction = secondFragmentManager.beginTransaction()

            val secondFragment = SecondFragment()
            // use replace method to replace fragment
            secondFragmentTransaction.replace(R.id.frame, secondFragment)

            // adding backstack method
            // when back button is pressed, previous screen retreived
            //
            secondFragmentTransaction.addToBackStack(null)

            secondFragmentTransaction.commit()
        }

        // onclick listener for dialog button
        btnDialog.setOnClickListener {
            val dialogManager: FragmentManager = supportFragmentManager
            // dialog fragment object
            val myDialog = DialogFragment()

            // not using transaction to show fragment
            // run the fragment: show()
            // 1: name of fragment object
            // 2: tag used to recognize method to open ::::: BE CAREFUL TO WRITE CLASS NAME, NOT OBJECT NAME
            myDialog.show(dialogManager, "DialogFragment")

            // setting cancellable method false to avoid closing dialog until button press
            myDialog.isCancelable = false

        }
    }

    // fun to write strings to textviews in Main Activity
    // outside on create function
    fun getUserData(userName: String, userPwd: Long){
        name.text = "Email: $userName"
        pwd.text = "Password: $userPwd"

    }
}