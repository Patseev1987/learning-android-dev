package com.example.tasks.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
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
    class TaskItemHolder(val rootView:CardView): RecyclerView.ViewHolder(rootView){
        val taskName = rootView.findViewById<TextView>(R.id.task_name)
        val taskDone = rootView.findViewById<CheckBox>(R.id.task_done)
        fun bind(item: Task) {
            taskName.text = item.taskName
            taskDone.isChecked = item.taskDone
        }

        companion object{
           fun inflateFrom(parent: ViewGroup):TaskItemHolder{
               val layoutInflater =LayoutInflater.from(parent.context)
               val view = layoutInflater.inflate(R.layout.task_item,parent,false) as CardView
               return TaskItemHolder(view)
           }
        }
    }
}