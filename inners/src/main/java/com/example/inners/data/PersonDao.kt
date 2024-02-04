package com.example.inners.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDao {
    @Insert
   suspend fun insert(person: Person)

    @Query ("Select * from people order by person_id")
    fun getAll():LiveData<List<Person>>
}