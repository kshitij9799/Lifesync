package com.example.lifesync.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.lifesync.R

class AddTaskFragment : Fragment() {

    companion object {
        fun newInstance() = AddTaskFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_add_task, container, false)
        val subBtn = view.findViewById<Button>(R.id.sub_btn)

        subBtn.setOnClickListener{
            val title = view.findViewById<EditText>(R.id.taskTitle).text.toString()
            val desc = view.findViewById<EditText>(R.id.titleDesc).text.toString()

            Toast.makeText(context, title + desc , Toast.LENGTH_SHORT).show()
        }

        return view
    }
}