package com.example.listfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class FlowerFragment : Fragment() {
    //create object of imageview
    lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // cannot access find view by id directly, hence create view object and then access
        val view: View = inflater.inflate(R.layout.fragment_flower, container, false)
        imageView = view.findViewById(R.id.ivFlower)

        val position = arguments?.getInt("position", 0)
        // when condition to set images for selected list item
        when(position){

            0 -> imageView.setImageResource(R.drawable.rose)
            1 -> imageView.setImageResource(R.drawable.sunflower)
            2 -> imageView.setImageResource(R.drawable.daffodil)
            3 -> imageView.setImageResource(R.drawable.daisy)
            4 -> imageView.setImageResource(R.drawable.lavendar)
            5 -> imageView.setImageResource(R.drawable.bell_flower)
            6 -> imageView.setImageResource(R.drawable.aster)
        }

        // Inflate the layout for this fragment
        // return the view created
        return view
    }
}