package com.example.safebox.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.safebox.R
import kotlinx.android.synthetic.main.fragment_mainscreen.*


class Mainscreen : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mainscreen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appCompatImageView.setOnClickListener {


        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.options_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mainscree2 -> {
                findNavController().navigate(R.id.action_mainscreen_to_secondScreenFragment)
                true
            }
            R.id.signout -> {
                true
            }   R.id.connect -> {
                findNavController().navigate(R.id.action_mainscreen_to_connectScreenFragment)

                true
            }   R.id.managelist -> {
                findNavController().navigate(R.id.action_mainscreen_to_listFragment)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}