package com.driskimaulana.animequotesretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.driskimaulana.animequotesretrofit.databinding.ActivityQuoteListBinding
import com.driskimaulana.animequotesretrofit.databinding.QuoteItemBinding

class QuoteListAdapter : RecyclerView.Adapter<QuoteListAdapter.QuoteHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Quote>()
    {
        override fun areItemsTheSame(oldItem: Quote, newItem: Quote): Boolean {
            return oldItem.quote == newItem.quote
        }

        override fun areContentsTheSame(oldItem: Quote, newItem: Quote): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var quoteList: List<Quote>
        get() = differ.currentList
        set(value) {differ.submitList(value)}

    inner class QuoteHolder(val binding: QuoteItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteHolder {
        return QuoteHolder(QuoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: QuoteHolder, position: Int) {
        holder.binding.tvQuotes.text = quoteList[position].quote
        holder.binding.tvAuthor.text = quoteList[position].character
        holder.binding.tvAnime.text = quoteList[position].anime
    }

    override fun getItemCount() = quoteList.size
}