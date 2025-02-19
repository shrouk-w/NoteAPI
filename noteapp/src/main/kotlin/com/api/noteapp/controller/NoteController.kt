package com.api.noteapp.controller

import com.api.noteapp.data.Note
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/notes")
@EnableAutoConfiguration
class NoteController {

    @GetMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
    )
    fun getNotes() : List<Note> {
        return listOf(
            Note(
                id = UUID.randomUUID().toString(),
                title = "title",
                content = "content",
            ),
            Note(
                id = UUID.randomUUID().toString(),
                title = "title2",
                content = "skibidi sigma to jest pięć, te piosenkęeeee"
            )
        )
    }

    @PutMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun insertNote(@RequestBody note: Note) : Note {
        note.id = UUID.randomUUID().toString()
        return note
    }

    @DeleteMapping(
        value = ["/{id}"],
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun deleteNote(@PathVariable(name = "id") id: String) : Boolean {
        println("deleting note with id: $id")
        return true
    }

    @PostMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun updateNote(@RequestBody note: Note) : Note {
        note.title += "[zmiana]"
        note.content += "[zmiana]"
        return note
    }

}