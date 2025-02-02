package com.example.lifesync.fragment

import com.example.lifesync.db.User
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lifesync.viewmodel.PandingTaskViewModel
import com.example.lifesync.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext
import kotlin.getValue

@AndroidEntryPoint
class PandingTaskFragment : Fragment() {

    companion object {
        fun newInstance() = PandingTaskFragment()
    }

    private val viewModel: PandingTaskViewModel  by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view =inflater.inflate(R.layout.fragment_panding_task, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.user.observe(viewLifecycleOwner){
            Log.d("checkdata", "onCreateView: $it")
            lifecycle.coroutineScope.launch(Dispatchers.Main){
                if (it.size > 1) viewModel.deleteUser(it[0])
            }
        }


        return view
    }

}