package com.example.safebox.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.safebox.R


class ConnectScreenFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_connect_screen, container, false)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.connect_options, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mainscree1 -> {
                findNavController().navigate(R.id.action_connectScreenFragment_to_mainscreen)
                true
            }
            R.id.signout -> {
                true
            }   R.id.screen2 -> {
                findNavController().navigate(R.id.action_connectScreenFragment_to_secondScreenFragment)

                true
            }   R.id.managelist -> {
                findNavController().navigate(R.id.action_connectScreenFragment_to_listFragment)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}