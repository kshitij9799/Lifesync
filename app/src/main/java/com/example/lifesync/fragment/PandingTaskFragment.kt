package com.example.lifesync.fragment

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
import com.example.lifesync.R
import com.example.lifesync.adapters.TaskAdapter
import com.example.lifesync.databinding.FragmentPandingTaskBinding
import com.example.lifesync.viewmodel.PandingTaskViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.getValue

@AndroidEntryPoint
class PandingTaskFragment : Fragment() {

    companion object {
        fun newInstance() = PandingTaskFragment()
    }

    private val viewModel: PandingTaskViewModel  by viewModels()
    private lateinit var binding: FragmentPandingTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPandingTaskBinding.inflate(inflater, container, false)

        binding.forMeTxt.setOnClickListener {
            binding.dbRecycler.visibility = View.VISIBLE
            binding.forAllRecycler.visibility = View.GONE
            binding.forMeTxt.setBackgroundColor(resources.getColor(R.color.grey))
            binding.forEveryOneTxt.background = null
        }

        binding.forEveryOneTxt.setOnClickListener {
            binding.forAllRecycler.visibility = View.VISIBLE
            binding.dbRecycler.visibility = View.GONE
            binding.forMeTxt.background = null
            binding.forEveryOneTxt.setBackgroundColor(resources.getColor(R.color.grey))
            lifecycle.coroutineScope.launch(Dispatchers.IO){
                val task = viewModel.getOnlineTask()
                withContext(Dispatchers.Main) {
                    binding.forAllRecycler.adapter = TaskAdapter(null, task, true)
                }
            }
        }

        viewModel.user.observe(viewLifecycleOwner){
            Log.d("checkdata", "onCreateView: $it")
            lifecycle.coroutineScope.launch(Dispatchers.Main){
                binding.dbRecycler.adapter = TaskAdapter(it, null, false)
            }
        }

        return binding.root
    }

}