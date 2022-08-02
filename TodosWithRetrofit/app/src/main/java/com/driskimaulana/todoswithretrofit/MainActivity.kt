package com.driskimaulana.todoswithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.driskimaulana.todoswithretrofit.databinding.ActivityMainBinding
import retrofit2.HttpException
import java.io.IOException

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var todosAdapter: TodosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

//        fetch data run on the background using Coroutine
        lifecycleScope.launchWhenCreated {
            binding.progressBar.isVisible = true

//            create request for todos data using retrofit instance that already created
            val response = try {
                RetrofitInstance.api.getTodos()
            } catch (e: IOException) {
                Log.e(TAG, "IOException: You might not have Internet connection")
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException: Unexpected Response")
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            }

//            check the response, whether it's successfull or null
            if (response.isSuccessful && response.body() != null) {
                response.body()?.let { it -> todosAdapter.todos = it }
            } else {
                Log.e(TAG, "Response not successfull")
            }

            binding.progressBar.isVisible = false
        }
    }

    private fun setupRecyclerView() {
        binding.recviewTodos.apply {
            todosAdapter = TodosAdapter()
            adapter = todosAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}