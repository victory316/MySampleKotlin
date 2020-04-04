package com.example.sampleappbyme.main.data

class SampleRepository(
    val sampleRemoteDataSource: SampleDataSource,
    val smapleLocalDataSource: SampleDataSource
): SampleDataSource {

    companion object {

        private var INSTANCE: SampleRepository? = null

        /**
         * Returns the single instance of this class, creating it if necessary.
         * @param tasksRemoteDataSource the backend data source
         * *
         * @param tasksLocalDataSource  the device storage data source
         * *
         * @return the [TasksRepository] instance
         */
        @JvmStatic fun getInstance(sampleRemoteDataSource: SampleDataSource,
                                   sampleLocalDataSource: SampleDataSource) =
            INSTANCE ?: synchronized(SampleRepository::class.java) {
                INSTANCE ?: SampleRepository(sampleRemoteDataSource, sampleLocalDataSource)
                    .also { INSTANCE = it }
            }


        /**
         * Used to force [getInstance] to create a new instance
         * next time it's called.
         */
        @JvmStatic fun destroyInstance() {
            INSTANCE = null
        }
    }
}