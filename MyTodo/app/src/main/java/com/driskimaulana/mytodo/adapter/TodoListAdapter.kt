package com.driskimaulana.mytodo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.driskimaulana.mytodo.data.TodoDatabase
import com.driskimaulana.mytodo.databinding.TodoItemBinding
import com.driskimaulana.mytodo.model.Todo
import com.driskimaulana.mytodo.repository.TodoRepository
import com.driskimaulana.mytodo.viewmodel.TodoViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class TodoListAdapter(private val context: Context) : RecyclerView.Adapter<TodoListAdapter.TodoHolder>() {

    private lateinit var mcontext: Context

    private lateinit var todoRepository: TodoRepository

    private val diffUtil = object : DiffUtil.ItemCallback<Todo>(){
        override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer<Todo>(this, diffUtil)

    var todoList: List<Todo>
        get() {
            return differ.currentList
        }
        set(value) {
            differ.submitList(value)
        }

    inner class TodoHolder(val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
        mcontext = parent.context
        val todoDao = TodoDatabase.getDatabase(mcontext).todoDao()
        todoRepository = TodoRepository(todoDao)
        return TodoHolder(TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
        holder.binding.apply {
            var todo = todoList[position]
            tvTodo.text = todo.title

            if(todo.status == "Not Done") btnDone.visibility = View.VISIBLE

            btnDone.setOnClickListener {
                todo.status = "Done"
                CoroutineScope(Dispatchers.IO).launch {
                    todoRepository.markAsComplete(todo)
                }
                Toast.makeText(mcontext, "Done Button is Clicked!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount() = todoList.size
}