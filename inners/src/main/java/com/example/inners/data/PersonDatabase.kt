package com.example.inners.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Person::class], version = 1, exportSchema = false)
abstract class PersonDatabase:RoomDatabase() {
    abstract val dao:PersonDao

    companion object{
        var INSTANCE:PersonDatabase? = null

        fun getInstance(context: Context):PersonDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(context.applicationContext,PersonDatabase::class.java,"people_database").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}