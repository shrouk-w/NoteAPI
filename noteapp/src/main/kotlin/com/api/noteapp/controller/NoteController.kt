package com.api.noteapp.controller

import com.api.noteapp.data.Note
import com.api.noteapp.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notes")
@EnableAutoConfiguration
class NoteController {
    @Autowired
    private lateinit var service: NoteService

    @GetMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
    )
    fun getNotes() = service.getNotes()



    @PutMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun insertNote(@RequestBody note: Note) = service.insertNote(note)



    @DeleteMapping(
        value = ["/{id}"],
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun deleteNote(@PathVariable(name = "id") id: String) : Boolean = service.deleteNote(id)



    @PostMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun updateNote(@RequestBody note: Note) = service.updateNote(note)

}