package com.api.noteapp.controller

import com.api.noteapp.data.ToDo
import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/todos")
@EnableAutoConfiguration

class ToDoController {
    @GetMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun getTodos(): List<ToDo>
    {
        return Arrays.asList(
            ToDo(
                UUID.randomUUID().toString(),
                title = "first task",
                content = "skibidi fortnite womp womp",
                schedule = System.currentTimeMillis(),
            ),
            ToDo(
                UUID.randomUUID().toString(),
                title = "cinco task",
                content = "do you are have stupido",
                schedule = System.currentTimeMillis()+10
            )
        )
    }

    @PutMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun insertTodo(
        @RequestBody todo: ToDo
    ): ToDo
    {
        return todo
    }

    @DeleteMapping(
        value = ["/{id}"],
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun deleteTodo(
        @PathVariable("id") id: String
    ) : Boolean
    {
        println("deleted todo with id: $id")
        return true
    }

    @PostMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun updateTodo(
        @RequestBody todo: ToDo
    ) : ToDo
    {
        todo.title += "[zimana]"
        todo.content += "[zimana]"
        todo.schedule = System.currentTimeMillis()+1000
        return todo
    }


}