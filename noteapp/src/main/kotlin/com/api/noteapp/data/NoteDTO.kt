package com.api.noteapp.data

import java.util.*

data class NoteDTO (
    var title: String="",
    var content: String="",
    var location: String=""
) {
    var id: Int = 0
    var created: Date = Date()
    var modified: Date = Date()

    constructor(note: Note) : this(note.title, note.content, note.location){
        id = note.id
        created = note.created
        modified = note.updated
    }
}