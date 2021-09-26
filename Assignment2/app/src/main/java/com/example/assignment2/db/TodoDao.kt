package com.example.assignment2.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.assignment2.model.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM todo_table")
    fun getALLTodos() : LiveData<List<Todo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo)

    //@Query("DELETE FROM todo_table WHERE todo_table.id=:id")
    //suspend fun deleteTodo(id: Long)

    @Delete
    suspend fun deleteTodo(todo:Todo)

}
