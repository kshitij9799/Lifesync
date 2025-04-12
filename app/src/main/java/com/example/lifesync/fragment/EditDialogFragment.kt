package com.example.lifesync.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import com.example.lifesync.db.Task
import com.example.lifesync.viewmodel.EditTaskViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.getValue
import kotlin.let

@AndroidEntryPoint
class EditDialogFragment(
    private val task: Task
) : DialogFragment() {

    private val viewModel: EditTaskViewModel by viewModels()


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(task.task)
                .setMessage("is task completed?")
                .setPositiveButton("Yes") { dialog, id ->
                    val task = Task(task.id,task.task, task.desc, "completed")

                    lifecycle.coroutineScope.launch(Dispatchers.IO) {
                        viewModel.updateUser(task)
                    }

                    dialog.dismiss()
                }
                .setNegativeButton("No") { dialog, id ->
                    dialog.dismiss()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}