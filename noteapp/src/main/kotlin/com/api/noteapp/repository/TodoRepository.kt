package com.api.noteapp.repository

import com.api.noteapp.data.ToDo
import org.springframework.data.repository.CrudRepository

interface TodoRepository: CrudRepository<ToDo, String> {
}