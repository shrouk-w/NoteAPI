package com.api.noteapp.service

import com.api.noteapp.data.Note
import org.springframework.stereotype.Service
import java.util.*


@Service("Note service")
class NoteService {
    fun getNotes(): List<Note> = listOf(
        Note(
            title = "title",
            content = "content",
        ),
        Note(
            title = "title2",
            content = "skibidi sigma to jest pięć, te piosenkęeeee"
        )
    )

    fun insertNote(note: Note): Note {
        note.id = UUID.randomUUID().toString()
        return note
    }

    fun updateNote(note: Note): Boolean = false

    fun deleteNote(id: String): Boolean = true


}