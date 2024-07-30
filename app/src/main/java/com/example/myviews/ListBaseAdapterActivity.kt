package com.example.myviews

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myviews.databinding.ActivityListBaseAdapterBinding
import com.example.myviews.databinding.ActivityListViewBinding

class ListBaseAdapterActivity : AppCompatActivity() {

    lateinit var binding: ActivityListBaseAdapterBinding
    var list= arrayListOf("c","c++","java")
    var studentlist= arrayListOf<Student>()
    var listAdapter=ListAdapter(studentlist)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding= ActivityListBaseAdapterBinding.inflate(layoutInflater)  //binding initialization
        setContentView(binding.root)


        setContentView(R.layout.activity_list_base_adapter)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        studentlist.add(Student(RollNo = 1,"Test","c"))
        studentlist.add(Student(RollNo = 2,"best","c++"))
        studentlist.add(Student(RollNo = 3,"jest","java"))
      // binding.baseadapterlistview.adapter=lisAdapter

      //  binding?.list










    }
}