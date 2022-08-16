package com.driskimaulana.animequotesretrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.driskimaulana.animequotesretrofit.databinding.AnimeItemBinding

class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.AnimeHolder>() {


    private lateinit var mFragmentManager: FragmentManager
    private lateinit var animeListFragment: ListAnimeFragment

    private  lateinit var mcontext: Context

    inner class AnimeHolder(val binding: AnimeItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }
    
    private val diffCallback = object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var animeList: List<String>
        get() = differ.currentList
        set(value) {differ.submitList(value)}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeHolder {
        mcontext = parent.context
        return AnimeHolder(AnimeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: AnimeHolder, position: Int) {
        holder.binding.tvAnime.text = animeList[position]

        holder.itemView.setOnClickListener{
            Toast.makeText(mcontext, "${animeList[position]} clicked", Toast.LENGTH_SHORT)
        }

    }

    override fun getItemCount() = animeList.size
}