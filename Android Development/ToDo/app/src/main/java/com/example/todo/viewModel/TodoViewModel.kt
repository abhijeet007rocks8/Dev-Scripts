package com.example.todo.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todo.data.ToDo
import com.example.todo.database.TodoDatabase
import com.example.todo.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TodoRepository
    val allTodos: LiveData<List<ToDo>>

    init {
        val todoDao = TodoDatabase.getTodoDatabaseInstance(application).getTodoDao()
        repository = TodoRepository(todoDao)
        allTodos = repository.allTodos
    }

    // using coroutines to handle async operations

    fun addTodo(toDo: ToDo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTodo(toDo)
        }
    }

    fun updateTodo(toDo: ToDo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTodo(toDo)
        }
    }

    fun deleteTodo(toDo: ToDo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTodo(toDo)
        }
    }

    fun deleteAllTodos() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllTodos()
        }
    }
}
