package com.example.sampleappbyme.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.sampleappbyme.R
import com.example.sampleappbyme.main.data.SampleRepository

class MainViewModel(
    val sampleRepository: SampleRepository
) : ViewModel() {

    private lateinit var navController: NavController

    fun setNavController(controller: NavController) {
        navController = controller
    }

    // CardView ViewPager로 페이지 변경
    fun goToCardViewViewPager() {
        navController.navigate(R.id.action_go_to_recycler_view_fragment)
    }
}
