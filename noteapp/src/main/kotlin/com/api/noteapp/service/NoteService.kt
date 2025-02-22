package com.api.noteapp.service

import com.api.noteapp.data.Note
import com.api.noteapp.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("Note service")
class NoteService {
    @Autowired
    lateinit var repository: NoteRepository

    fun getNotes(): Iterable<Note> = repository.findAll()

    fun insertNote(note: Note): Note = repository.save(note)

    fun updateNote(note: Note): Note = repository.save(note)

    fun deleteNote(id: String)= repository.deleteById(id)


}