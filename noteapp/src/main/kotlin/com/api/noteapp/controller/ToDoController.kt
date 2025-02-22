package com.api.noteapp.controller

import com.api.noteapp.data.ToDo
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
    fun getTodos(): List<ToDo> = service.getTodos()



    @PutMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun insertTodo(
        @RequestBody todo: ToDo
    ): ToDo = service.insertTodo(todo)



    @DeleteMapping(
        value = ["/{id}"],
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun deleteTodo(
        @PathVariable("id") id: String
    ) : Boolean = service.deleteTodo(id)



    @PostMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun updateTodo(
        @RequestBody todo: ToDo
    ) : Boolean = service.updateTodo(todo)


}