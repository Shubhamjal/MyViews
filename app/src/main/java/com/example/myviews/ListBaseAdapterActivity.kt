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

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        studentlist.add(Student(  1,"Test","c"))
        studentlist.add(Student(  2,"best","c++"))
        studentlist.add(Student(  3,"jest","java"))

       binding.baseadapterlistview.adapter=listAdapter


    }
}