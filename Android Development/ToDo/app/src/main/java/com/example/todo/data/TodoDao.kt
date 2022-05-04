package com.example.todo.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTodo(todo: ToDo)

    @Query("SELECT * FROM todo_table ORDER BY ID ASC")
    fun getAllTodos(): LiveData<List<ToDo>>

    @Update
    suspend fun updateTodo(todo: ToDo)

    @Delete
    suspend fun deleteTodo(todo: ToDo)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAllTodos()

}
