package com.example.sampleappbyme.main.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.sampleappbyme.R
import com.example.sampleappbyme.main.data.SampleRepository

class MainViewModel : ViewModel() {

    private lateinit var navController: NavController
    var showToast = ObservableBoolean()
    var startForegroundService = ObservableBoolean()

    fun setNavController(controller: NavController) {
        navController = controller
    }

    // CardView ViewPager로 페이지 변경
    fun goToCardViewViewPager() {
        navController.navigate(R.id.action_go_to_card_view_fragment)
    }

    fun goToTaskViewFragment() {
        navController.navigate(R.id.action_go_to_task_view_fragment)
    }

    fun showNotYetToast() {
        showToast.set(true)
    }

    fun startForegroundService() {
        startForegroundService.set(true)
    }

    fun startLifecycleFragment() {

    }
}
