package com.example.listfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.ListFragment

class FirstFragment : ListFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // adapter to access array list
        // context = activity, RequiredActivity() or surround with let keyword
        val adapter = activity?.let {
            ArrayAdapter.createFromResource(it,
                R.array.flowers, android.R.layout.simple_list_item_1)
        }

        // accessing the code
        listAdapter = adapter

        // set on click listener for listview item
        listView.setOnItemClickListener { adapterView, view, position, id ->

            // first param in fragment is activity and applicationContext in Activity
            val intent = Intent(activity, SecondActivity::class.java)
            // to get position of list item clicked
            intent.putExtra("position", position)
            startActivity(intent)
        }
    }
}