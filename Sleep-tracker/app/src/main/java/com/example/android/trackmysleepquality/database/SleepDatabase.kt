/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.trackmysleepquality.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SleepNight::class], version = 1, exportSchema = false)
abstract class SleepDatabase : RoomDatabase() {

    abstract val sleepDatabaseDao: SleepDatabaseDao

    /// Allows clients to access the methods without declaring the class
    companion object {
        /// This will help us to avoid open different connections to the DB
        @Volatile
        private var INSTANCE: SleepDatabase? = null
    }

    /// This will return the reference for the DB
    fun getInstance(context: Context): SleepDatabase {
        /// Only can support one connection, so we have only one instantiation
        synchronized(this) {
            var instance = INSTANCE
            if (instance == null) {
                instance = Room.databaseBuilder(
                        context.applicationContext,
                        SleepDatabase::class.java,
                        "sleep_history_database"
                )
                        .fallbackToDestructiveMigration()
                        .build()

                INSTANCE = instance
            }
            return instance;
        }
    }

    /// [Volatile and Synchronized] -> https://developer.android.com/jetpack/docs/guide#separation-of-concerns
    /// [Migration DB] -> https://medium.com/androiddevelopers/understanding-migrations-with-room-f01e04b07929
}