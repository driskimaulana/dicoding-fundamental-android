package com.driskimaulana.randomquotesloopj

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.driskimaulana.randomquotesloopj.databinding.QuotesCardBinding

class QuoteListAdapter(private val quoteList: ArrayList<Quote>) : RecyclerView.Adapter<QuoteListAdapter.QuoteListHolder>() {
    inner class QuoteListHolder(val binding: QuotesCardBinding) : RecyclerView.ViewHolder(binding.root) {
        
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteListHolder {
        val binding = QuotesCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return QuoteListHolder(binding)
    }

    override fun onBindViewHolder(holder: QuoteListHolder, position: Int) {
        with(holder){
            with(quoteList[position])
            {
                binding.tvQuotes.text = quoteList[position].quote
                binding.tvAuthors.text = quoteList[position].author
            }
        }
    }

    override fun getItemCount(): Int {
        return quoteList.size
    }
}