package com.example.rings.viewmodels.vmfind

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rings.model.RingDao

class FindViewModelFactory(private val dao:RingDao):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FindViewModel::class.java)){
            return FindViewModel(dao) as T
        }else{
            throw IllegalArgumentException ("Unknown ViewModel")
        }
    }
}