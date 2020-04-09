package com.example.sampleappbyme.main.util

import android.content.Context
import com.example.sampleappbyme.main.data.*
import com.example.sampleappbyme.main.data.local.SampleLocalDataSource
import com.example.sampleappbyme.main.data.remote.FakeTasksRemoteDataSource
import com.example.sampleappbyme.main.util.AppExecutors

object Injection {
    fun provideTasksRepository(context: Context): SampleRepository {

        val database = SampleDatabase.getInstance(context)

        return SampleRepository.getInstance(
            FakeTasksRemoteDataSource,
            SampleLocalDataSource.getInstance(AppExecutors(), database.sampleDao()))
    }
}