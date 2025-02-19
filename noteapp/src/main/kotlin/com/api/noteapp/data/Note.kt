package com.api.noteapp.data

data class Note(
    var id:String = "",
    var title:String,
    var content:String,
    var location:String = ""
){}