package com.example.myviews

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListAdapter(var list:ArrayList<Student>): BaseAdapter(){
    override fun getCount(): Int {
        return list.size
        TODO("Not yet implemented")
    }

    override fun getItem(porsiton: Int): Any {
        return list[porsiton]
        TODO("Not yet implemented")
    }

    override fun getItemId(porsiton: Int): Long {
        return porsiton.toLong()
        TODO("Not yet implemented")
    }

    @SuppressLint("MissingInflatedId", "ViewHolder")
    override fun getView(position: Int, contentview: View?, parent: ViewGroup?): View {

        val view=LayoutInflater.from(parent?.context)
            .inflate(R.layout.activity_list_base_adapter,parent,false)

        var rollNo=view.findViewById<TextView>(R.id.itemRollno)
        rollNo.setText(list[position].RollNo.toString())

        var name=view.findViewById<TextView>(R.id.itemStudentName)
        name.setText(list[position].Name)
        return view


        TODO("Not yet implemented")
    }

}