package com.example.todo.repository

import androidx.lifecycle.LiveData
import com.example.todo.data.ToDo
import com.example.todo.data.TodoDao

class TodoRepository(private val todoDao: TodoDao) {

    val allTodos: LiveData<List<ToDo>> = todoDao.getAllTodos()

    suspend fun addTodo(toDo: ToDo) {
        todoDao.addTodo(toDo)
    }

    suspend fun updateTodo(toDo: ToDo) {
        todoDao.updateTodo(toDo)
    }

    suspend fun deleteTodo(toDo: ToDo) {
        todoDao.deleteTodo(toDo)
    }

    suspend fun deleteAllTodos() {
        todoDao.deleteAllTodos()
    }
}
