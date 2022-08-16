package com.driskimaulana.animequotesretrofit

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.driskimaulana.animequotesretrofit.databinding.FragmentListAnimeBinding
import retrofit2.HttpException
import java.io.IOException

class ListAnimeFragment : Fragment() {

    companion object {
        private const val TAG = "ListAnimeFragment"
    }

    private lateinit var binding: FragmentListAnimeBinding

    private lateinit var animeAdapter: AnimeAdapter

    private lateinit var mcontext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentListAnimeBinding.inflate(layoutInflater)
        mcontext = binding.root.context

        setupRecview()
//        create reques for anime list data
        lifecycleScope.launchWhenCreated { 
            val response = try {
                binding.progressbar.isVisible = true
                RetrofitInstance.api.getAvailableAnime()
            }catch (e: IOException)
            {
                binding.progressbar.isVisible = false
                Log.e(TAG, "IOException: You might not have internet connection", )
                return@launchWhenCreated
            }catch (e: HttpException){
                binding.progressbar.isVisible = false
                Log.e(TAG, "HttpException: Unexpected response" )
                return@launchWhenCreated
            }

            if(response.isSuccessful && response.body() != null)
            {
                response.body()?.let { it -> animeAdapter.animeList = it }
            }

            binding.progressbar.isVisible = false

        }

        binding.recView.addItemDecoration(
            DividerItemDecoration(
                mcontext,
                LinearLayoutManager(mcontext).orientation
            )
        )

//        return inflater.inflate(R.layout.fragment_list_anime, container, false)
        return binding.root
    }

    private fun setupRecview() {
        binding.recView.apply {
            animeAdapter = AnimeAdapter()
            adapter = animeAdapter
            layoutManager = LinearLayoutManager(mcontext)
        }
    }

}