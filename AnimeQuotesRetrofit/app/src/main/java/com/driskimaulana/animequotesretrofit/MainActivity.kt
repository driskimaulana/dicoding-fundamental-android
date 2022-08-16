package com.driskimaulana.animequotesretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.driskimaulana.animequotesretrofit.databinding.ActivityMainBinding
import retrofit2.HttpException
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        private val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        lifecycleScope.launchWhenCreated {

            binding.progressbar.isVisible = true

            val response = try {

                RetrofitInstance.api.getRandomQuotes()

            } catch (e: IOException){
                binding.progressbar.isVisible = false
                Log.e(TAG, "IOException: You might not have internet" )
                return@launchWhenCreated
            } catch (e: HttpException){
                binding.progressbar.isVisible = false
                Log.e(TAG, "HttpException: Unexpected resonse")
                return@launchWhenCreated
            }

            if (response.isSuccessful && response.body() != null)
            {
                binding.tvQuotes.text = response.body()?.let { it -> it.quote }
                binding.tvAnime.text = "- ${response.body()?.let { it -> it.anime }} -"
                binding.tvAuthor.text = response.body()?.let { it -> it.character }
            }

            binding.progressbar.isVisible = false

            binding.btnQuoteList.setOnClickListener {
                startActivity(Intent(this@MainActivity, QuoteListActivity::class.java))
            }

            binding.btnListAnime.setOnClickListener {
                startActivity(Intent(this@MainActivity, AnimeListActivity::class.java))
            }

        }

    }
}