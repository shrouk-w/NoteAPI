package com.api.noteapp.data

import java.util.*

data class ToDoDTO (
    var title: String="",
    var content: String="",
    var schedule: Long=-1,
    var location: String=""
) {
    var id: Int = 0
    var created: Date = Date()
    var modified: Date = Date()

    constructor(todo: ToDo): this(todo.title, todo.content, todo.schedule, todo.location){
        id = todo.id
        created = todo.created
        modified = todo.updated
    }
}