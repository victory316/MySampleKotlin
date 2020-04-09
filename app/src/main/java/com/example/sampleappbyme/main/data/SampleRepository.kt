package com.example.sampleappbyme.main.data

class SampleRepository(
    val sampleRemoteDataSource: SampleDataSource,
    val smapleLocalDataSource: SampleDataSource
): SampleDataSource {

    override fun getTask(taskId: String, callback: SampleDataSource.GetTaskCallback) {
//        val taskInCache = getTaskWithId(taskId)

        // Respond immediately with cache if available
//        if (taskInCache != null) {
//            callback.onTaskLoaded(taskInCache)
//            return
//        }

//        EspressoIdlingResource.increment() // Set app as busy.

        // Load from server/persisted if needed.

        // Is the task in the local data source? If not, query the network.
//        tasksLocalDataSource.getTask(taskId, object : TasksDataSource.GetTaskCallback {
//            override fun onTaskLoaded(task: Task) {
//                // Do in memory cache update to keep the app UI up to date
//                cacheAndPerform(task) {
//                    EspressoIdlingResource.decrement() // Set app as idle.
//                    callback.onTaskLoaded(it)
//                }
//            }
//
//            override fun onDataNotAvailable() {
//                tasksRemoteDataSource.getTask(taskId, object : TasksDataSource.GetTaskCallback {
//                    override fun onTaskLoaded(task: Task) {
//                        // Do in memory cache update to keep the app UI up to date
//                        cacheAndPerform(task) {
//                            EspressoIdlingResource.decrement() // Set app as idle.
//                            callback.onTaskLoaded(it)
//                        }
//                    }
//
//                    override fun onDataNotAvailable() {
//                        EspressoIdlingResource.decrement() // Set app as idle.
//                        callback.onDataNotAvailable()
//                    }
//                })
//            }
//        })
    }

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