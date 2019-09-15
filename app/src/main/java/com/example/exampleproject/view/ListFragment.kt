package com.example.testapplication.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.exampleproject.R
import com.example.exampleproject.viewmodel.MainActivityViewModel

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private val viewModel: MainActivityViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

}
