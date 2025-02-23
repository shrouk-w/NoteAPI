package com.api.noteapp.controller

import com.api.noteapp.data.ToDo
import com.api.noteapp.data.ToDoDTO
import com.api.noteapp.service.ToDoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
@EnableAutoConfiguration

class ToDoController {

    @Autowired
    private lateinit var service: ToDoService

    @GetMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun getTodos(): Iterable<ToDoDTO> = service.getTodos()



    @PutMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun insertTodo(
        @RequestBody todo: ToDoDTO
    ): ToDoDTO = service.insertTodo(todo)



    @DeleteMapping(
        value = ["/{id}"],
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun deleteTodo(
        @PathVariable("id") id: String
    ) = service.deleteTodo(id)



    @PostMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun updateTodo(
        @RequestBody todo: ToDoDTO
    ) : ToDoDTO = service.updateTodo(todo)


}