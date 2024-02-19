package com.example.rings.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RingDao {
    @Insert
    suspend fun insert(ring:Ring)

    @Delete
    suspend fun delete(ring: Ring)

    @Update
    suspend fun update(ring:Ring)

    @Query("SELECT * FROM rings")
    fun getAll(): LiveData<List<Ring>>

    @Query("Select * FROM rings WHERE diameter = :diameter")
    fun getRingsWithDiameter(diameter:Double):LiveData<List<Ring>>


}