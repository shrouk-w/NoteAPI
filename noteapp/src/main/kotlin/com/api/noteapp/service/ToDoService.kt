package com.api.noteapp.service
import com.api.noteapp.data.ToDo
import com.api.noteapp.repository.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service("ToDo service")
class ToDoService {
    @Autowired
    lateinit var repository: TodoRepository

    fun getTodos(): Iterable<ToDo> = repository.findAll()

    fun insertTodo(toDo: ToDo): ToDo = repository.save(toDo)

    fun deleteTodo(id: String) = repository.deleteById(id)

    fun updateTodo(toDo: ToDo): ToDo = repository.save(toDo)
}