package com.example.sampleappbyme.main.view.fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.Observable
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.sampleappbyme.databinding.MainFragmentBinding
import com.example.sampleappbyme.main.util.SampleForegroundService
import com.example.sampleappbyme.main.view.MainActivity
import timber.log.Timber


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
                viewModel = (activity as MainActivity).obtainViewModel().apply {
                    setNavController(navController)

                    // Toast Message 출력 설정
                    showToast.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                            if (viewModel!!.showToast.get()) {
                                showToast()
                                viewModel!!.showToast.set(false)
                            }
                        }
                    })

                    startForegroundService.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                            if (viewModel!!.startForegroundService.get()) {
                                Timber.tag("Timber").d("mutable : ${viewModel!!.startForegroundService.get()}")

                                if (!serviceActivated) {
                                    startService()
                                } else {
                                    stopService()
                                }
                                viewModel!!.startForegroundService.set(false)
                            }
                        }
                    })
                }
            }

        return mainFragmentBinding.root
    }

    fun showToast() {
        activity.run {
            Toast.makeText(context, "Not yet finished :)", Toast.LENGTH_SHORT).show()
        }
    }

    private var serviceActivated = false

    fun startService() {

        val serviceIntent = Intent(context, SampleForegroundService::class.java)
        serviceIntent.putExtra("inputExtra", "Foreground Service Example in Android")
        ContextCompat.startForegroundService(context!!, serviceIntent)
        serviceActivated = true

        Toast.makeText(context, "Starting foreground service", Toast.LENGTH_SHORT).show()
    }

    fun stopService() {
        val serviceIntent = Intent(context, SampleForegroundService::class.java)
        activity!!.stopService(serviceIntent)
        serviceActivated = false

        Toast.makeText(context, "Finishing foreground service", Toast.LENGTH_SHORT).show()
    }

}
