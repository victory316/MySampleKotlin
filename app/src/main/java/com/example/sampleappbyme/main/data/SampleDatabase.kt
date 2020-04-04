package com.example.sampleappbyme.main.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SampleData::class], version = 1)
abstract class SampleDatabase: RoomDatabase() {
    abstract fun sampleDao(): SampleDao

    companion object {

        private var INSTANCE: SampleDatabase? = null

        private val lock = Any()

        fun getInstance(context: Context): SampleDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        SampleDatabase::class.java, "Samples.db")
                        .build()
                }
                return INSTANCE!!
            }
        }
    }
}