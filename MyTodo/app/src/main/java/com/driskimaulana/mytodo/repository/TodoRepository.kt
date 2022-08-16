package com.driskimaulana.mytodo.repository

import androidx.lifecycle.LiveData
import com.driskimaulana.mytodo.data.TodoDao
import com.driskimaulana.mytodo.model.Todo

class TodoRepository(private val todoDao: TodoDao) {

    val readAllData: LiveData<List<Todo>>
        get() {
            return todoDao.readAllTodo()
        }

    suspend fun addData(newTodo: Todo){
        todoDao.addTodo(newTodo)
    }

    suspend fun markAsComplete(todoComplete: Todo){
        todoDao.todoCompleted(todoComplete)
    }

}