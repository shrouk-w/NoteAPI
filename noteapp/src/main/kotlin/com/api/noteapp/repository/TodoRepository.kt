package com.api.noteapp.repository

import com.api.noteapp.data.ToDo
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface TodoRepository: CrudRepository<ToDo, String> {
    @Query("FROM ToDo WHERE schedule > ?1")
    fun findScheduledLaterThan(date: Long): Iterable<ToDo>

}