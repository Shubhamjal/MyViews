package com.example.myviews

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myviews.databinding.ActivitySpinnerViewBinding



class SpinnerViewActivity : AppCompatActivity() {

    lateinit var binding: ActivitySpinnerViewBinding  //Activity binding
    lateinit var arrayAdapter:ArrayAdapter<String>
    var spinnervalues = mutableListOf("one","Two","Thee")
    var DynamicSpinner= mutableListOf("one","two","three")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding=ActivitySpinnerViewBinding.inflate(layoutInflater)   //implementing
        setContentView(binding.root)

        setContentView(R.layout.activity_spinner_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //normal spinner implementation
        binding.Spinner.onItemSelectedListener= object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var selectedItem=binding.Spinner.selectedItem as String
                Toast.makeText(this@SpinnerViewActivity,"@selectedItem",Toast.LENGTH_SHORT).show()

                TODO("Not yet implemented")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }






        //Dynamic Spinner Implementation
        arrayAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,DynamicSpinner)
        binding.DynamicSpinner.adapter=arrayAdapter
        binding.DynamicSpinner.onItemSelectedListener=object:OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {


                var selectedItem=binding.DynamicSpinner.selectedItem as String
                Toast.makeText(this@SpinnerViewActivity,"selectedItem",Toast.LENGTH_SHORT).show()

                TODO("Not yet implemented")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

       binding. FabBtn1.setOnClickListener {
            // Show dialog to add item
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.spinner_add_dialogbox)
            val editText: EditText = dialog.findViewById(R.id.DataEntered)
            val button: Button = dialog.findViewById(R.id.Enterbtnspinner)

            button.setOnClickListener {
                val newItem = editText.text.toString()
                if (newItem.isNotEmpty()) {
                    DynamicSpinner.add(newItem)
                    arrayAdapter.notifyDataSetChanged()
                    dialog.dismiss()
                } else {
                    Toast.makeText(this, "Please enter a valid item", Toast.LENGTH_SHORT).show()
                }
            }

            dialog.show()
        }
    }
}

//        //adding the data
//        binding.FabBtn1.setOnClickListener{
//            val dialog=Dialog(this)
//            dialog.setContentView(R.layout.spinner_add_dialogbox)
//            val data_entered = dialog.findViewById<EditText>(R.id.DataEntered)
//            val btn = dialog.findViewById<Button>(R.id.Enterbtnspinner)
//            btn.setOnClickListener {
//                DynamicSpinner.add(data_entered.text.toString())
//                arrayAdapter.notifyDataSetChanged()
//                dialog.dismiss()
//            }
//            dialog.show()
//        }
//
//        //deleting the data
//        binding.FabBtn2.setOnClickListener{
//            val dialog=Dialog(this)
//            dialog.setContentView(R.layout.spinner_delete_dialogbox)
//            val btn1 = dialog.findViewById<Button>(R.id.yes_btn_spinner)
//            val btn2 = dialog.findViewById<Button>(R.id.no_btn_spinner)
//            dialog.show()
//            btn1.setOnClickListener {
//
//            }
//
//        }
//
//
//        //deleting the data
//        binding.DynamicSpinner.setOnItemLongClickListener{ parent: AdapterView<*>, view: View, position: Int, id: Long ->
//
//            val dialog=Dialog(this)
//            dialog.setContentView(R.layout.spinner_delete_dialogbox)
//            val btn1 = dialog.findViewById<Button>(R.id.yes_btn_spinner)
//            val btn2 = dialog.findViewById<Button>(R.id.no_btn_spinner)
//
//            dialog.show()
//
//            btn1.setOnClickListener {
//                spinnervalues.removeAt(position)
//                arrayAdapter.notifyDataSetChanged()
//                dialog.dismiss()
//            }
//            btn2.setOnClickListener {
//                Toast.makeText(this,"deletion canceled",Toast.LENGTH_SHORT).show()
//                dialog.dismiss()
//            }
//            return@setOnItemLongClickListener true
//
//        }
//
//
//
//
//
//
//
//        //updating the data
//        binding.DynamicSpinner.setOnItemClickListener{ parent,view,position,id->
//            Toast.makeText(this,"$position",Toast.LENGTH_SHORT).show()
//            //code for updating the clicked data
//            val dialog=Dialog(this)
//            dialog.setContentView(R.layout.spinner_update_dialogbox)
//            val update=dialog.findViewById<TextView>(R.id.Spinner_Update_Box)
//            val btn=dialog.findViewById<Button>(R.id.Update_btn_spinner)
//
//            btn.setOnClickListener {
//                spinnervalues.set(position,update.text.toString())
//                arrayAdapter.notifyDataSetChanged()
//                dialog.dismiss()
//            }
//            dialog.show()
//
//        }
//











