package com.example.lifesync

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yourpa.db.INoteRVAdapter
import com.example.yourpa.db.Note
import com.example.yourpa.db.NoteAdapter

class PandingTaskFragment : Fragment(),INoteRVAdapter {

    companion object {
        fun newInstance() = PandingTaskFragment()
    }

    private lateinit var viewModel: PandingTaskViewModel

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
        var list: List<Note> = listOf(Note("a"),Note("b"),Note("b"),Note("b"),Note("b"),Note("b"))
        val adapter = NoteAdapter(requireContext(),this,list)
        recyclerView.adapter = adapter


//        viewModel = ViewModelProvider(
//            this,
//            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
//        )[PandingTaskViewModel::class.java]
//
//        viewModel.allNotes.observe(viewLifecycleOwner, Observer {list ->
//            list?.let {
//                adapter.updateList(list)
//            }
//        })

        return view
    }

    override fun onItemClicked(note: Note) {
//        viewModel.deleteNote(note)
    }


}