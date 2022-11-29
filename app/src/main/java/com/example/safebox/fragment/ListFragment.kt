package com.example.safebox.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.safebox.ListAdaptor
import com.example.safebox.MainViewModel
import com.example.safebox.R
import com.example.safebox.`interface`.onclickListener
import com.example.safebox.model.Safebox
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ListFragment : Fragment(), onclickListener {
    lateinit var arrayList: ArrayList<Safebox>
    lateinit var listAdaptor: ListAdaptor
    private val mainViewModel: MainViewModel by sharedViewModel()
    lateinit var layout: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arrayList = arrayListOf()
        arrayList.add(Safebox("abc", "connected"))
        arrayList.add(Safebox("abc", "connected"))
        arrayList.add(Safebox("abc", "connected"))
        arrayList.add(Safebox("abc", "connected"))
        arrayList.add(Safebox("abc", "connected"))
        arrayList.add(Safebox("abc", "connected"))
        arrayList.add(Safebox("abc", "connected"))
        layout = LinearLayoutManager(requireContext())
        listAdaptor = ListAdaptor(requireContext(), arrayList, this)
        list.layoutManager = layout
        list.adapter = listAdaptor


    }

    override fun onClick(name: String, status: String) {
        mainViewModel.name = name
        mainViewModel.status = status
        findNavController().navigate(R.id.action_listFragment_to_secondScreenFragment)
    }


    override fun onDelete() {
    }

    override fun onEdti() {
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.options_for_list, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mainscree2 -> {
                findNavController().navigate(R.id.action_listFragment_to_secondScreenFragment)
                true
            }
            R.id.signout -> {
                true
            }   R.id.connect -> {
                findNavController().navigate(R.id.action_listFragment_to_connectScreenFragment)

                true
            }   R.id.mainscreenn1 -> {
                findNavController().navigate(R.id.action_listFragment_to_mainscreen)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}