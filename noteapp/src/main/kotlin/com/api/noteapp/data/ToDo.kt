package com.api.noteapp.data

import java.util.*

data class ToDo(
    var id:String? = "",
    var title : String,
    var content : String,
    var schedule : Long,
    var location : String? = "",
)
{
    init {
        if(id==null)
            id = UUID.randomUUID().toString()
        if(location==null)
            location = ""
    }
}