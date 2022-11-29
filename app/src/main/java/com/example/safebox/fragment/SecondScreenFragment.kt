package com.example.safebox.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.safebox.MainViewModel
import com.example.safebox.R
import kotlinx.android.synthetic.main.fragment_second_screen.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SecondScreenFragment : Fragment() {
    private val mainViewModel: MainViewModel by sharedViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        name_of_safe.text=   mainViewModel.name
        status.text=   mainViewModel.status





    }

}