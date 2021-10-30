package com.example.notesappfullroom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesappfullroom.databinding.NotesRowBinding


class RV(val active :MainActivity): RecyclerView.Adapter<RV.ItemBinding>() {
    private var notee = emptyList<NoteDclass>()
    class ItemBinding (val bin : NotesRowBinding):RecyclerView.ViewHolder(bin.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemBinding {
        return ItemBinding(NotesRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: ItemBinding, position: Int) {
        val notes = notee[position]
        holder.bin.apply{
            mSubTitle.text = notes.note
            updatebt.setOnClickListener {
                active.dilogfun(notes.id)
            }
            deletebt.setOnClickListener {
                active.model.deleteNote(notes.id)
            } } }

    override fun getItemCount()=notee.size
    fun update(notes: List<NoteDclass>){
        println("data updated")
        this.notee = notes
        notifyDataSetChanged()
    }
}