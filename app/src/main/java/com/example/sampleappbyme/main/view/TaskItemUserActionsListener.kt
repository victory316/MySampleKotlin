package com.example.sampleappbyme.main.view

import android.view.View
import com.example.sampleappbyme.main.data.SampleData

interface TaskItemUserActionsListener {
    fun onCompleteChanged(task: SampleData, v: View)

    fun onTaskClicked(task: SampleData)
}