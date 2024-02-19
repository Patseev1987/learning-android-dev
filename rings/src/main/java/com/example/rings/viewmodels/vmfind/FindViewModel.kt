package com.example.rings.viewmodels.vmfind

import androidx.lifecycle.ViewModel
import com.example.rings.model.RingDao

class FindViewModel(val dao: RingDao):ViewModel() {
    val rings = dao.getAll()
    fun getRingsWithDiameter (diameter:Double) = dao.getRingsWithDiameter(diameter)


}