package com.example.sampleappbyme.main.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SampleDao {
    @Query("SELECT * FROM sample")
    fun getAll(): LiveData<List<SampleData>>
}