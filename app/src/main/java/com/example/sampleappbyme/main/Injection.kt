package com.example.sampleappbyme.main

import android.content.Context
import com.example.sampleappbyme.main.data.*
import com.example.sampleappbyme.main.util.AppExecutors

object Injection {
    fun provideTasksRepository(context: Context): SampleRepository {

        val database = SampleDatabase.getInstance(context)

        return SampleRepository.getInstance(FakeTasksRemoteDataSource,
            SampleLocalDataSource.getInstance(AppExecutors(), database.sampleDao()))
    }
}