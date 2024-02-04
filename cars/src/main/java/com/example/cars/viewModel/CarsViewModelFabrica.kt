package com.example.cars.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cars.data.CarsDao

class CarsViewModelFabrica(private val carsDao:CarsDao):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CarsViewModel::class.java)){
            return CarsViewModel(carsDao) as T
        }
        throw IllegalArgumentException("Unknown ModelView")
    }
}