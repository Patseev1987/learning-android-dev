package com.example.rings.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Ring::class], version = 1 , exportSchema = false)
abstract class RingDatabase:RoomDatabase() {
    abstract val dao:RingDao

    companion object{
        private var INSTANCE:RingDatabase? = null

        fun getInstance(context:Context):RingDatabase{
            synchronized(this){
                var instance = INSTANCE
                if( instance ==null){
                    instance = Room.databaseBuilder(context,RingDatabase::class.java,"rings_database").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}