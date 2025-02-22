package com.api.noteapp.service

import com.api.noteapp.data.ToDo
import org.springframework.stereotype.Service
import java.util.*

@Service("ToDo service")
class ToDoService {

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

    fun insertTodo(toDo: ToDo): ToDo{
        toDo.id = UUID.randomUUID().toString()
        return toDo
    }

    fun deleteTodo(id: String): Boolean = false

    fun updateTodo(toDo: ToDo): Boolean = true
}