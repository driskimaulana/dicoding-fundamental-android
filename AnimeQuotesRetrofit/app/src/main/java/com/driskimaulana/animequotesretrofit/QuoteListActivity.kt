package com.driskimaulana.animequotesretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.driskimaulana.animequotesretrofit.databinding.ActivityQuoteListBinding
import retrofit2.HttpException
import java.io.IOException

class QuoteListActivity : AppCompatActivity() {

    companion object {
        private val TAG = "QuoteListActivity"
    }

    private lateinit var binding: ActivityQuoteListBinding

    private lateinit var quoteListAdapter: QuoteListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecView()

        lifecycleScope.launchWhenCreated {
            val response = try {
                binding.progressBar.isVisible = true
                RetrofitInstance.api.getTenQuotes()
            }catch (e: IOException){
                Log.e(TAG, "IOException: You might not have internet connection" )
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            }catch (e: HttpException)
            {
                Log.e(TAG, "HttpException: Unexpected response")
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            }

            if(response.isSuccessful && response.body() != null)
            {
                response.body()?.let {it ->
                    quoteListAdapter.quoteList = it
                }
            }

            binding.progressBar.isVisible = false

        }

    }

    private fun setupRecView() {
        binding.recView.apply {
            quoteListAdapter = QuoteListAdapter()
            adapter = quoteListAdapter
            layoutManager = LinearLayoutManager(this@QuoteListActivity)
        }
    }
}