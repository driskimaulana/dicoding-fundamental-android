package com.driskimaulana.animequotesretrofit

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.driskimaulana.animequotesretrofit.databinding.FragmentQuoteByAnimeListBinding
import retrofit2.HttpException
import java.io.IOException


class QuoteByAnimeListFragment : Fragment() {

    companion object {
        private const val TAG = "QuoteByAnime"
    }

    private lateinit var binding: FragmentQuoteByAnimeListBinding

    private lateinit var animeAdapter: QuoteListAdapter
    private lateinit var mcontext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentQuoteByAnimeListBinding.inflate(layoutInflater)

        mcontext = binding.root.context

        setupRecview()

//        lifecycleScope.launchWhenCreated {
//            val response = try {
//                binding.progressBar.isVisible = true
//                RetrofitInstance.api.getQuotesByAnime()
//            }catch (e: IOException){
//                binding.progressBar.isVisible = false
//                Log.e(TAG, "IOException: You might not have internet connection")
//                return@launchWhenCreated
//            }catch (e: HttpException){
//                binding.progressBar.isVisible = false
//                Log.e(TAG, "HttpException: Unexpected response")
//                return@launchWhenCreated
//            }
//
//            if(response.isSuccessful && response.body() != null)
//            {
//                response.body()?.let{it -> animeAdapter.quoteList = it}
//            }
//
//            binding.progressBar.isVisible = false
//        }

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setupRecview() {
        binding.recView.apply {
            animeAdapter = QuoteListAdapter()
            adapter = animeAdapter
            layoutManager = LinearLayoutManager(mcontext)
        }
    }

}