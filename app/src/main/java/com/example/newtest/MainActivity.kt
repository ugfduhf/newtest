package com.example.newtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.sql.Ref

class MainActivity : AppCompatActivity() {
    var floatingActionButton: FloatingActionButton? = null

    var mRef: DatabaseReference? = null
    var btn_add1: Button? = null
    var add_title1: EditText? = null
    var add_subtitle1: EditText? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectView()

        var database = FirebaseDatabase.getInstance()

        //gev object into firebase in realtime
        mRef = database.getReference("Notes")

        //open the floatActionButton
        floatingActionButton?.setOnClickListener {

            showDialogAddNote()


        }

    }
    fun  connectView() {
        floatingActionButton = findViewById(R.id.floatingActionButton)



    }

    fun showDialogAddNote() {
        val aletBuilder = AlertDialog.Builder(this)

        var view = layoutInflater.inflate(R.layout.add_note,null)

        add_title1 = view.findViewById(R.id.add_title)
        add_subtitle1 = view.findViewById(R.id.add_subtitle)
        btn_add1 = view.findViewById(R.id.btn_add)

        aletBuilder.setView(view)
        val alertDialog = aletBuilder.create()
        alertDialog.show()
        btn_add1?.setOnClickListener {
            var title = add_title1?.text.toString()
            val subtitle = add_subtitle1?.text.toString()
            if (title.isNotEmpty() && subtitle.isNotEmpty()) {
                //Toast.makeText(this,"successful",Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Empty", Toast.LENGTH_LONG).show()
            }

        }
    }

}
