package com.agesa.navigationcomponent.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.agesa.navigationcomponent.HomeFragment
import com.agesa.navigationcomponent.HomeFragmentDirections
import com.agesa.navigationcomponent.R
import kotlinx.android.synthetic.main.fragment_feed.view.*


class FeedFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_feed, container, false)
        view.recycler.adapter = BoatsAdapter(BOATS, ::onBoatClick)
        view.recycler.layoutManager = LinearLayoutManager(view.context)
        return view
    }

    private fun onBoatClick(boatId: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToBoatFragment(boatId)
        activity?.findNavController(R.id.nav_container)?.navigate(action)

    }
}

