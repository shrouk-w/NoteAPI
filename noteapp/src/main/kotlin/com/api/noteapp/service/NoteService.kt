package com.api.noteapp.service

import com.api.noteapp.data.Note
import com.api.noteapp.data.NoteDTO
import com.api.noteapp.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service("Note service")
class NoteService {
    @Autowired
    lateinit var repository: NoteRepository

    fun getNotes(): Iterable<NoteDTO> = repository.findAll().map{fortnite->NoteDTO(fortnite)}

    fun insertNote(note: NoteDTO) = NoteDTO(repository.save(
        Note(title = note.title, content = note.content, location = note.location)
    ))

    fun updateNote(noteDto: NoteDTO): NoteDTO {
        var note: Note = repository.findById(noteDto.id.toString()).get()
        note.title = noteDto.title
        note.content = noteDto.content
        note.location = noteDto.location
        note.updated = Date()
        note = repository.save(note)
        return NoteDTO(note)
    }

    fun deleteNote(id: String)= repository.deleteById(id)

    fun findByTitle(title: String): Iterable<NoteDTO> = repository.findByTitle(title).map{NoteDTO(it)}


}