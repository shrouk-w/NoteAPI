package com.api.noteapp.service
import com.api.noteapp.data.ToDo
import com.api.noteapp.data.ToDoDTO
import com.api.noteapp.repository.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service("ToDo service")
class ToDoService {
    @Autowired
    lateinit var repository: TodoRepository

    fun getTodos(): Iterable<ToDoDTO> = repository.findAll().map{v->ToDoDTO(v)}

    fun insertTodo(toDo: ToDoDTO): ToDoDTO = ToDoDTO(repository.save(
        ToDo(
            title = toDo.title,
            content = toDo.content,
            schedule = toDo.schedule,
            location = toDo.location
        )
    ))

    fun deleteTodo(id: String) = repository.deleteById(id)

    fun updateTodo(toDoDto: ToDoDTO): ToDoDTO {
        var todo: ToDo = repository.findById(toDoDto.id.toString()).get()
        todo.title=toDoDto.title
        todo.content = toDoDto.content
        todo.schedule = toDoDto.schedule
        todo.location = toDoDto.location
        todo.updated = Date()
        todo = repository.save(todo)
        return ToDoDTO(todo)
    }
}