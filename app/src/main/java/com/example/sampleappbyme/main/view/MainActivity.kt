package com.example.sampleappbyme.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.sampleappbyme.R
import com.example.sampleappbyme.main.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.nav_host)

        Handler().postDelayed({
            navController.navigate(R.id.action_go_to_main_fragment)
        }, 1500)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_host).navigateUp()

    fun obtainViewModel(): MainViewModel {
        return MainViewModel()
    }
}
