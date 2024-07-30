package com.example.myviews

data class Student(
    var RollNo:Int?=0,
    var Name:String?="",
    var subject: String?="",
){
    override fun toString(): String {
        return "$RollNo\n$Name\n$subject"
    }
}

