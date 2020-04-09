package com.example.sampleappbyme.main.data

interface SampleDataSource {

    interface GetTaskCallback {

        fun onTaskLoaded(task: SampleData)

        fun onDataNotAvailable()
    }

    fun getTask(taskId: String, callback: GetTaskCallback)
}