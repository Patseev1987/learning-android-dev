package com.example.cars.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Car::class], version = 2, exportSchema = false)
abstract class CarsDatabase : RoomDatabase() {

    abstract val carDao: CarsDao

    companion object {
        @Volatile
        private var INSTANCE: CarsDatabase? = null

        fun getInstance (context: Context): CarsDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CarsDatabase::class.java,
                        "carssss"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}