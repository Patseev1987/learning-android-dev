package com.example.cars.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CarsDao {
    @Insert
    suspend fun insert (car: Car)
    @Delete
   suspend fun delete(car:Car)

   @Update
   suspend fun update(car:Car)

   @Query("Select * from cars_table where cars_table.model = :model")
   fun getCar(model:String):LiveData<Car>

   @Query("Select * from cars_table order by cars_table.model")
   fun getAll():LiveData<List<Car>>


}