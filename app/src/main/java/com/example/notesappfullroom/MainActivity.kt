package com.example.notesappfullroom

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rc: RecyclerView
    private lateinit var ed: EditText
    private lateinit var notebutton: Button
    private lateinit var rv:RV
    lateinit var model:Model
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        model= ViewModelProvider(this).get(Model::class.java)
        model.getNotes().observe(this,{
            notes -> rv.update(notes)
        })

        ed=findViewById(R.id.editTextTextPersonName)
        notebutton=findViewById(R.id.button)
        rc=findViewById(R.id.RVv)

        notebutton.setOnClickListener {

            model.addNote(ed.text.toString())
            ed.text.clear()
            ed.clearFocus()
        }
        rv=RV(this)
        rc.adapter=rv
        rc.layoutManager= LinearLayoutManager(this)

    }

    fun dilogfun(id:Int) {
        val build = AlertDialog.Builder(this)
        val update = EditText(this)
        update.hint = " enter new note for update "
        build.setCancelable(false)
            .setPositiveButton("save", DialogInterface.OnClickListener() { _, _ ->
                model.editNote(id, update.text.toString())
            })
            .setNegativeButton("deny", DialogInterface.OnClickListener {
                dialog,_->dialog.cancel()
            })
        val alert = build.create()
        alert.setTitle("Update Note")
        alert.setView(update)
        alert.show()
    }
}