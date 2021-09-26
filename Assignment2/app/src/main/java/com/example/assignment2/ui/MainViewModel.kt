package com.example.assignment2.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment2.App
import com.example.assignment2.model.Todo
import com.example.assignment2.repository.TodoRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val todoRepository by lazy { (application as App).todoRepository }

    fun observeTodo() = todoRepository.getTodos()

    fun insertTodo(title: String, content: String) {
        viewModelScope.launch {
            todoRepository.insertTodo(Todo(title, content))
        }
    }

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch {
            todoRepository.deleteTodo(todo)
        }
    }

}
