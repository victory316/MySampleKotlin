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

        navController = findNavController()

        mainFragmentBinding = MainFragmentBinding.inflate(inflater, container, false)
            .apply {
                // activity로부터 viewModel 로드 및 navController 설정
                viewModel = (activity as MainActivity).obtainViewModel()
                viewModel?.setNavController(navController)
            }

        return mainFragmentBinding.root
    }
}
