package com.api.noteapp.controller

import com.api.noteapp.data.Note
import com.api.noteapp.data.NoteDTO
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
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    fun getNotes() = service.getNotes()



    @PutMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun insertNote(@RequestBody note: NoteDTO) = service.insertNote(note)



    @DeleteMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteNote(@PathVariable(name = "id") id: String) = service.deleteNote(id)



    @PostMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateNote(@RequestBody note: NoteDTO): NoteDTO = service.updateNote(note)

}