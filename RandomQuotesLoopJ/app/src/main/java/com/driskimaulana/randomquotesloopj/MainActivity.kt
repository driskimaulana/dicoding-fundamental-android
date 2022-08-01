package com.driskimaulana.randomquotesloopj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.driskimaulana.randomquotesloopj.databinding.ActivityMainBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()

        getRandomQuotes()
    }

    private fun getRandomQuotes() {

        binding.progressBar.visibility = View.VISIBLE

        val client = AsyncHttpClient()
        val url = "https://quote-api.dicoding.dev/random"
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?
            ) {
                binding.progressBar.visibility = View.INVISIBLE

                val result = responseBody?.let { String(it) }
                Log.d(TAG, "onSuccess: $result")

                try {
                    val responseObject = JSONObject(result)
                    val quote = responseObject.getString("en")
                    val author = responseObject.getString("author")

                    binding.tvQuotes.text = quote
                    binding.tvAuthors.text = author

                } catch (e: Exception) {
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()

                    e.printStackTrace()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {

                binding.progressBar.visibility = View.VISIBLE

                val errorMessage = when (statusCode) {
                    401 -> "$statusCode: Bad Request"
                    402 -> "$statusCode: Forbidden"
                    403 -> "$statusCode: Not Found"
                    else -> "$statusCode: ${error?.message}"
                }

                Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }

        })

        binding.btnShowQuotesList.setOnClickListener{
            startActivity(Intent(this, QuoteListActivity::class.java))
        }
    }

    companion object {

        private val TAG = MainActivity::class.java.simpleName

    }
}

