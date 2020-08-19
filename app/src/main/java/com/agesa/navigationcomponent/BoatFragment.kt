package com.agesa.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.agesa.navigationcomponent.feed.BOATS
import com.agesa.navigationcomponent.feed.getBoat
import kotlinx.android.synthetic.main.fragment_boat.view.*


class BoatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //val id= arguments?.getInt("id") ?: error("id is null")
        val id = arguments?.let { BoatFragmentArgs.fromBundle(it).id }
        val boat= id?.let { BOATS.getBoat(it) }

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_boat, container, false)
        if (boat != null) {
            view.nameTextView.text=boat.name
        }
        if (boat != null) {
            view.locationTextView.text=boat.location
        }
        if (boat != null) {
            view.imageView2.setImageResource(boat.picture)
        }
        if (boat != null) {
            view.priceTextView.text=boat.price
        }

        return view
    }
}