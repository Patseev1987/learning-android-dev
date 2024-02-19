package com.example.todolist

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

import kotlin.random.Random

class ToDoListActivity : AppCompatActivity() {


    private lateinit var linearLayoutNote:LinearLayout
    private val notes:MutableList<Note> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)
        initView()
        fillLinearLayout()


    }

private fun fillLinearLayout(){
    for (note in notes){
        val view = layoutInflater.inflate(R.layout.note,linearLayoutNote,false)
        val nameNote:TextView = view.findViewById(R.id.TextView_note)
        nameNote.text = note.name
        val color = when (note.priority){
            0 -> ContextCompat.getColor(this,android.R.color.holo_red_light)
            1-> ContextCompat.getColor(this,android.R.color.holo_orange_light)
            else -> ContextCompat.getColor(this,android.R.color.holo_green_light)
        }
        view.setBackgroundColor(color)
        linearLayoutNote.addView(view)
    }
}

    private fun initView(){
        linearLayoutNote = findViewById(R.id.to_do_list_linear_layout)
        for (i in 0..50){
            notes.add(Note(id = i, priority = Random.nextInt(3),name = "Note $i"))
        }
    }

}