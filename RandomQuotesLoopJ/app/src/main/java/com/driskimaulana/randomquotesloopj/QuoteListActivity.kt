package com.driskimaulana.randomquotesloopj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.driskimaulana.randomquotesloopj.databinding.ActivityQuoteListBinding
import com.driskimaulana.randomquotesloopj.databinding.QuotesCardBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

import org.json.JSONArray

class QuoteListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuoteListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityQuoteListBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recView.layoutManager = LinearLayoutManager(this)
        binding.recView.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager(this).orientation
            )
        )

        getQuoteList()
    }

    private fun getQuoteList() {

        binding.progressBar2.visibility = View.VISIBLE

        val client = AsyncHttpClient()
        val url = "https://quote-api.dicoding.dev/list"

        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?
            ) {
                binding.progressBar2.visibility = View.INVISIBLE

                val result = responseBody?.let { String(it) }
                Log.d(TAG, "onSuccess: $result")
                try {
                    val quoteList = arrayListOf<Quote>()
                    val responseObject = JSONArray(result)
                    for (i in 0 until responseObject.length() - 1) {
                        val quote = responseObject.getJSONObject(i).getString("en")
                        val author = responseObject.getJSONObject(i).getString("author")
                        quoteList.add(Quote(quote, author))
                    }

                    val adapter = QuoteListAdapter(quoteList)
                    binding.recView.adapter = adapter

                } catch (e: Exception) {
                    Toast.makeText(this@QuoteListActivity, e.message, Toast.LENGTH_SHORT).show()

                    e.printStackTrace()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                binding.progressBar2.visibility = View.VISIBLE

                val errorMessage = when (statusCode) {
                    401 -> "$statusCode: Bad Request"
                    402 -> "$statusCode: Forbidden"
                    403 -> "$statusCode: Not Found"
                    else -> "$statusCode: ${error?.message}"
                }

                Toast.makeText(this@QuoteListActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }

        })

    }

    companion object {
        private val TAG = QuoteListActivity::class.java.simpleName
    }
}