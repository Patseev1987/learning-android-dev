package com.example.inners.modelView

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.inners.data.Person
import com.example.inners.data.PersonDao
import kotlinx.coroutines.launch

class PersonModelView(val dao: PersonDao):ViewModel() {

    fun  add(name:String,lastname:String,age:Int){
        viewModelScope.launch {
            val person = Person()
            person.age = age
            person.name = name
            person.lastname = lastname
            dao.insert(person)
        }
    }

    val people = dao.getAll()

    val peopleString:LiveData<String>  = people.map { value -> value.fold(""){str,person ->
        str+"${person.person_id} ${person.name} ${person.lastname}\n age = ${person.age}\n"} }

}