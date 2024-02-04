package com.example.cars.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.cars.data.Car
import com.example.cars.data.CarsDao
import kotlinx.coroutines.launch

class CarsViewModel(val dao:CarsDao):ViewModel() {

    val cars = dao.getAll()

    val carsString = cars.map{
        item -> item.toString()
    }

    private fun formatCars(cars: List<Car>):String {
      return  cars.fold(""){str, item -> formatCars(item)}
    }

    private fun formatCars(car:Car):String{
        return """Model ---> ${car.model}
            |Year of manufactured ---> ${car.year}
            |Color ---> ${car.color}
            |
        """.trimMargin()
    }



    fun addCar(model:String, year:Int, color:String ) {
        viewModelScope.launch {
            val car = Car()
            car.model = model
            car.year = year
            car.color =color
            dao.insert(car)
        }
    }






}