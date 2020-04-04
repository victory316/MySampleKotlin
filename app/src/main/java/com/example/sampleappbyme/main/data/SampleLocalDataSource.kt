package com.example.sampleappbyme.main.data

import androidx.annotation.VisibleForTesting
import com.example.sampleappbyme.main.util.AppExecutors

class SampleLocalDataSource(
    val appExecutors: AppExecutors,
    val sampleDao: SampleDao
): SampleDataSource{

    companion object {
        private var INSTANCE: SampleLocalDataSource? = null

        @JvmStatic
        fun getInstance(appExecutors: AppExecutors, sampleDao: SampleDao): SampleLocalDataSource {
            if (INSTANCE == null) {
                synchronized(SampleLocalDataSource::javaClass) {
                    INSTANCE = SampleLocalDataSource(appExecutors, sampleDao)
                }
            }
            return INSTANCE!!
        }

        @VisibleForTesting
        fun clearInstance() {
            INSTANCE = null
        }
    }
}