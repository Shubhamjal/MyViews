package com.example.myviews

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myviews.databinding.ActivityListViewBinding

class ListViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityListViewBinding   //Activity Binding
    var array= arrayListOf("one","two","three")
    var arrayAdapter:ArrayAdapter<String>?=null
    private val TAG = "ListViewActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding=ActivityListViewBinding.inflate(layoutInflater)  //binding initialization
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        arrayAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_activated_1,array)

        binding.ListView.adapter=arrayAdapter



        //setting up toast for item being clicked in the list
        binding.ListView.setOnItemClickListener { parent, view, position, id ->

          Toast.makeText(this,"$position",Toast.LENGTH_SHORT).show()

            val dialog = Dialog(this)
            dialog.setContentView(R.layout.update_dialogbox)

        }

        //setting up toast for item being long clicked in the list
        binding.ListView.setOnItemLongClickListener { parent, view, position, id ->

            Toast.makeText(this@ListViewActivity,"$position",Toast.LENGTH_SHORT).show()
            return@setOnItemLongClickListener true

        }
        arrayAdapter?.notifyDataSetChanged()




        binding.FabBtn.setOnClickListener {                //adding alert dialog box to the floating action button
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.add_dialogbox)
            val entered_data = dialog.findViewById<EditText>(R.id.EnteredData)   //val entered_data=Entered data
            val btn = dialog.findViewById<Button>(R.id.Enterbtn)  //val btn = Enterbtn

            btn.setOnClickListener {             //adding functionality to the button click
                array.add(entered_data.text.toString())  //adding entered data in the list
                arrayAdapter?.notifyDataSetChanged()     //update the array when new element added
                dialog.dismiss()                         //close the dialog box
            }
            dialog.show()                                //open the dialog box
        }


    }
}