package com.driskimaulana.mytodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.driskimaulana.mytodo.adapter.TodoListAdapter
import com.driskimaulana.mytodo.databinding.ActivityMainBinding
import com.driskimaulana.mytodo.model.Todo
import com.driskimaulana.mytodo.viewmodel.TodoViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var  binding : ActivityMainBinding

    private lateinit var todoListAdapter: TodoListAdapter

    private lateinit var todoViewModel: TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]

        setupRecyclerView()


        todoViewModel.readAllData.observe(this, Observer{
            todoListAdapter.todoList = it
        })

        binding.btnAdd.setOnClickListener{
            if(binding.edtTodoTitle.text.isNotEmpty()){
                val newTodo = Todo(0, binding.edtTodoTitle.text.toString(), "Not Done")

                todoViewModel.addTodo(newTodo)
                binding.edtTodoTitle.setText("")
            }
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            // add divider decoration between the list
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
            todoListAdapter = TodoListAdapter(this@MainActivity)
            adapter = todoListAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}