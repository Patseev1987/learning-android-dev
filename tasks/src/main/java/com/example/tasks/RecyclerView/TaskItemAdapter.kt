package com.example.tasks.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tasks.R
import com.example.tasks.Task

class TaskItemAdapter:RecyclerView.Adapter<TaskItemAdapter.TaskItemHolder>() {
    var data = listOf<Task>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TaskItemHolder = TaskItemHolder.inflateFrom(p0)

    override fun onBindViewHolder(holder: TaskItemHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size
    class TaskItemHolder(val rootView:TextView): RecyclerView.ViewHolder(rootView){
        fun bind(item: Task) {
            rootView.text = item.taskName
        }

        companion object{
           fun inflateFrom(parent: ViewGroup):TaskItemHolder{
               val layoutInflater =LayoutInflater.from(parent.context)
               val view = layoutInflater.inflate(R.layout.task_item,parent,false) as TextView
               return TaskItemHolder(view)
           }
        }
    }
}