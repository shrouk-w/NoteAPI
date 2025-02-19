package com.api.noteapp.data

import java.util.*

data class Note(
    var id:String? = "",
    var title:String,
    var content:String,
    var location:String? = ""
){
    init {
        if(id==null)
            id = UUID.randomUUID().toString()
        if(location==null)
            location = ""
    }
}