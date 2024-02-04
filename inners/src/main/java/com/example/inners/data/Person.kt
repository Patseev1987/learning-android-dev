package com.example.inners.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "people")
data class Person (
    @PrimaryKey (autoGenerate = true)
    var person_id:Long = 0,
    var name:String = "",
    var lastname:String = "",
    var age:Int = -1
)