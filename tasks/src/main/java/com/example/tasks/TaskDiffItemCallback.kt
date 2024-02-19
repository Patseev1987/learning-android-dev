package com.example.tasks

import androidx.recyclerview.widget.DiffUtil

class TaskDiffItemCallback:DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(p0: Task, p1: Task): Boolean =
        (p0.taskId == p1.taskId)


    override fun areContentsTheSame(p0: Task, p1: Task): Boolean  = p0 == p1
}