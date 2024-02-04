package com.example.inners.modelView

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.inners.data.PersonDao

class PersonViewModelFactory(val dao:PersonDao):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonModelView::class.java)){
            return PersonModelView(dao) as T
        }
        throw IllegalArgumentException("unknown ViewModel")
    }
}