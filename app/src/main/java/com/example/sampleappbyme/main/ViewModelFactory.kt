package com.example.sampleappbyme.main

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sampleappbyme.main.data.SampleRepository
import com.example.sampleappbyme.main.viewmodel.MainViewModel
import com.example.sampleappbyme.main.viewmodel.TaskViewModel

class ViewModelFactory private constructor(
    private val sampleRepository: SampleRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(MainViewModel::class.java) ->
                    MainViewModel()
                isAssignableFrom(TaskViewModel::class.java) ->
                    TaskViewModel(sampleRepository)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T

    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application) =
            INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                INSTANCE ?: ViewModelFactory(
                    Injection.provideTasksRepository(application.applicationContext))
                        .also { INSTANCE = it }
            }
    }
}