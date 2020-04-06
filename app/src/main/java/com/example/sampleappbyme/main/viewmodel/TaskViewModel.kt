package com.example.sampleappbyme.main.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.sampleappbyme.R
import com.example.sampleappbyme.main.data.SampleData
import com.example.sampleappbyme.main.data.SampleRepository
import timber.log.Timber

class TaskViewModel(
    val sampleRepository: SampleRepository
) : ViewModel() {
    private val _items = MutableLiveData<List<SampleData>>().apply { value = emptyList() }
    val items: LiveData<List<SampleData>>
        get() = _items

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean>
        get() = _dataLoading

    private val _currentFilteringLabel = MutableLiveData<Int>()
    val currentFilteringLabel: LiveData<Int>
        get() = _currentFilteringLabel

    private val _noTasksLabel = MutableLiveData<Int>()
    val noTasksLabel: LiveData<Int>
        get() = _noTasksLabel

    private val _tasksAddViewVisible = MutableLiveData<Boolean>()
    val tasksAddViewVisible: LiveData<Boolean>
        get() = _tasksAddViewVisible

    private val _noTaskIconRes = MutableLiveData<Int>()
    val noTaskIconRes: LiveData<Int>
        get() = _noTaskIconRes

    //     This LiveData depends on another so we can use a transformation.
    val empty: LiveData<Boolean> = Transformations.map(_items) {
        Timber.tag("viewModelTest").d("is empty.")
        _tasksAddViewVisible.value = true
        it.isEmpty()
    }

    fun addNewTask() {

    }
}
