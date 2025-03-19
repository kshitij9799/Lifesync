package com.example.lifesync.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lifesync.db.Task
import com.example.lifesync.R
import com.example.lifesync.model.ForAllTask

class TaskAdapter(
    private val taskList: List<Task>?,
    private val onlineTaskList : List<ForAllTask>?,
    private val isOnlineTaskList : Boolean
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        if (isOnlineTaskList) {
            holder.titleTxt.text = onlineTaskList?.get(position)?.taskTitle
            holder.descText.text = onlineTaskList?.get(position)?.taskDesc
        }
        else {
            holder.titleTxt.text = taskList?.get(position)?.task
            holder.descText.text = taskList?.get(position)?.desc
        }
    }

    override fun getItemCount(): Int {
        if (isOnlineTaskList) {
            return onlineTaskList?.size ?: 0
        }
        return if (taskList.isNullOrEmpty()) 0 else taskList.size
    }

    inner class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTxt = view.findViewById<TextView>(R.id.titleTxt)
        val descText = view.findViewById<TextView>(R.id.descText)
    }
}