package com.driskimaulana.mytodo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.driskimaulana.mytodo.data.TodoDatabase
import com.driskimaulana.mytodo.model.Todo
import com.driskimaulana.mytodo.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TodoRepository

    var readAllData: LiveData<List<Todo>>

    init {
        val todoDao = TodoDatabase.getDatabase(application).todoDao()
        repository = TodoRepository(todoDao)
        readAllData = repository.readAllData
    }

    fun addTodo(todo: Todo){
        viewModelScope.launch(Dispatchers.IO){
            repository.addData(todo)
        }
    }
    
    fun markAsComplete(todo: Todo){
        viewModelScope.launch(Dispatchers.IO){
            repository.markAsComplete(todo)
        }
    }

}