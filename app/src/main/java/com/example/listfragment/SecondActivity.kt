package com.example.listfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //getting value in intent
        val position = intent.getIntExtra("position", 0)

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        val flowerFragment = FlowerFragment()

        // sending data from activity to fragment
        val bundle = Bundle()
        bundle.putInt("position", position)
        flowerFragment.arguments = bundle

        fragmentTransaction.add(R.id.frameLayout, flowerFragment)
        fragmentTransaction.commit()
    }
}