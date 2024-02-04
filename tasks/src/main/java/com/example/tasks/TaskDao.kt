package com.example.tasks

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface TaskDao {
    @Insert
   suspend fun insert(task:Task)

    @Update
    suspend fun update(task:Task)

    @Delete
    suspend fun delete(task:Task)

    @Query("SELECT * FROM task_table WHERE task_id = :taskId")
    fun get(taskId:Long):LiveData<Task>

    @Query("Select * From task_table order by task_id desc")
    fun getAll():LiveData<List<Task>>

}