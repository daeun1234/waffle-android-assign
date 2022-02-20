package com.example.assignment2.repository

import com.example.assignment2.db.TodoDao
import com.example.assignment2.model.Todo

class TodoRepository constructor(private val todoDao: TodoDao) {

    fun getTodos() = todoDao.getALLTodos()
    suspend fun insertTodo(todo: Todo) = todoDao.insertTodo(todo)
    suspend fun deleteTodo(todo: Todo) = todoDao.deleteTodo(todo)

    companion object {
        @Volatile
        private var INSTANCE: TodoRepository? = null

        @JvmStatic
        fun getInstance(todoDao: TodoDao): TodoRepository = INSTANCE ?: synchronized(this) {
            INSTANCE ?: TodoRepository(todoDao).also { INSTANCE = it }
        }
    }
}