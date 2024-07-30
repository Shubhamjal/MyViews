package com.example.myviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class ListAdapter(var list:ArrayList<Student>): BaseAdapter(){
    override fun getCount(): Int {
        return list.size
        TODO("Not yet implemented")
    }

    override fun getItem(p0: Int): Any {
        return list[p0]
        TODO("Not yet implemented")
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, contentview: View?, parent: ViewGroup?): View {

        val view=LayoutInflater.from(parent?.context)
            .inflate(R.layout.activity_list_base_adapter,parent,false)
        val


        TODO("Not yet implemented")
    }

}