package com.example.lifesync.db

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yourpa.PandingTaskFragment
import com.example.yourpa.R

class NoteAdapter(val context: Context, private val listener: PandingTaskFragment, private val list: List<Note>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder = NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false))
        viewHolder.imageView.setOnClickListener {
            listener.onItemClicked(this.list[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return this.list.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = this.list[position]
        holder.textView.text = currentNote.text
    }

    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)

    }
}

interface INoteRVAdapter {
    fun onItemClicked(note: Note)
}