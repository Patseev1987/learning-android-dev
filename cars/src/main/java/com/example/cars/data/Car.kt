package com.example.cars.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "cars_table")
data class Car(
    @PrimaryKey (autoGenerate = true)
    var id:Long = 0L,
    var model:String = "",
    var year:Int = 0,
    var color:String = ""
)
