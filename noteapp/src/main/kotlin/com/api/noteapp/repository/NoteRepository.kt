package com.api.noteapp.repository

import com.api.noteapp.data.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository: CrudRepository<Note, String> {
}