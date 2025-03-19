package com.example.lifesync.fragment

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.example.lifesync.viewmodel.BottomViewModel
import com.example.lifesync.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomFragment : Fragment() {

    companion object {
        fun newInstance() = BottomFragment()
        lateinit var addTaskButton: FloatingActionButton
    }

    private val viewModel: BottomViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_bottom, container, false)
        val bottomNavView = view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val fragmentContainerView = view.findViewById<FragmentContainerView>(R.id.bottom_nav_fragment_container)
        addTaskButton = view.findViewById<FloatingActionButton>(R.id.task_add_btn)

        addTaskButton.setOnClickListener {
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(fragmentContainerView.id, AddTaskFragment())
            transaction.commit()
        }

        bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.pending_task -> {
                    addTaskButton.show()
                    val transaction = childFragmentManager.beginTransaction()
                    transaction.replace(fragmentContainerView.id, PandingTaskFragment())
                    transaction.commit()
                    true
                }

                R.id.completed_task -> {
                    addTaskButton.hide()
                    val transaction = childFragmentManager.beginTransaction()
                    transaction.replace(fragmentContainerView.id, CompletedTaskFragment())
                    transaction.commit()
                    true
                }

                R.id.profile -> {
                    Toast.makeText(requireContext(), "Work is in progress", Toast.LENGTH_SHORT).show()
//                    val transaction = childFragmentManager.beginTransaction()
//                    transaction.replace(fragmentContainerView.id, ProfileFragment())
//                    transaction.commit()
                    true
                }

                else -> false

            }
        }


        return view
    }


}