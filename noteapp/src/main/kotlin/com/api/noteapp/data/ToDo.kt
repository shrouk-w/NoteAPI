package com.api.noteapp.data

data class ToDo(
    var id:String = "",
    var title : String,
    var content : String,
    var schedule : Long,
    var location : String="",
)
{}