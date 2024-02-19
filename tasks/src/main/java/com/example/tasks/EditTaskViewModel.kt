package com.example.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class EditTaskViewModel(val taskId:Long, val dao:TaskDao):ViewModel() {
    val task = dao.get(taskId)



        private var _navigateToList = MutableLiveData(false)
            val navigateToList:LiveData<Boolean>
                get() = _navigateToList

    fun updateTask() {
        viewModelScope.launch {
            dao.update(task.value!!)
            _navigateToList.value = true
        }
    }
        fun deleteTask(){
            viewModelScope.launch {
                dao.delete(task.value!!)
                _navigateToList.value = true
            }
        }
    fun onNavigateToList(){
        _navigateToList.value = false
    }
}