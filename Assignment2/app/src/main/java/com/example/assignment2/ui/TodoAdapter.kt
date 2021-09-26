package com.example.assignment2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2.databinding.ItemTodoBinding
import com.example.assignment2.model.Todo
import timber.log.Timber
import java.sql.DatabaseMetaData

// val table: DatabaseMetaData,
class TodoAdapter constructor(val onDeleteClickListener : (Todo) -> Unit)
    : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    private var todos: List<Todo> = listOf()

    inner class TodoViewHolder(val binding: ItemTodoBinding, onDeleteClickListener: (Todo) -> Unit) : RecyclerView.ViewHolder(binding.root) {

            fun delete(todo:Todo) {
                binding.buttonDone.setOnClickListener{
                    onDeleteClickListener(todo)
                }
            }
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TodoViewHolder(binding, onDeleteClickListener)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val data = todos[position]
        holder.binding.apply {
            textTitle.text = data.title
            textContent.text = data.content
        }
        holder.delete(data)
    }

    override fun getItemCount() : Int {
        return todos.size}

    fun setTodos(todos:List<Todo>) {
        this.todos = todos
        this.notifyDataSetChanged()
    }


}
