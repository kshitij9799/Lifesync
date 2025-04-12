package com.example.lifesync.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lifesync.db.Task
import com.example.lifesync.R
import com.example.lifesync.activity.MainActivity
import com.example.lifesync.fragment.EditDialogFragment
import com.example.lifesync.model.ForAllTask
import dagger.hilt.android.qualifiers.ActivityContext

class TaskAdapter(
    private val context: Context,
    private val taskList: List<Task>?, private val onlineTaskList : List<ForAllTask>?,
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
        with(holder){
            if (isOnlineTaskList) {
                titleTxt.text = onlineTaskList?.get(position)?.taskTitle
                descText.text = onlineTaskList?.get(position)?.taskDesc
            } else {
                titleTxt.text = taskList?.get(position)?.task
                descText.text = taskList?.get(position)?.desc
                ivEdit.setOnClickListener {
                        val editDialogFragment =  EditDialogFragment(taskList?.get(position)!!)
                        editDialogFragment.show((context as MainActivity).supportFragmentManager, "editDialog")

                }
            }
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
        val ivEdit = view.findViewById<ImageView>(R.id.ivEdit)
    }
}