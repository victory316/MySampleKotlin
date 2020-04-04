package com.example.sampleappbyme.main.view.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

import com.example.sampleappbyme.R
import com.example.sampleappbyme.databinding.MainFragmentBinding
import com.example.sampleappbyme.main.view.MainActivity
import com.example.sampleappbyme.main.viewmodel.MainViewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() =
            MainFragment()
    }

    private lateinit var mainFragmentBinding: MainFragmentBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainFragmentBinding = MainFragmentBinding.inflate(inflater, container, false)
            .apply {
                viewModel = (activity as MainActivity).obtainViewModel()
            }

        navController = findNavController()

        // viewModel에 navController 설정
        mainFragmentBinding.viewModel?.setNavController(navController)

        return mainFragmentBinding.root
    }
}
