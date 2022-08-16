package com.driskimaulana.animequotesretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.FragmentManager

import com.driskimaulana.animequotesretrofit.databinding.ActivityAnimeListBinding


class AnimeListActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "AnimeListActivity"
    }

    private lateinit var binding: ActivityAnimeListBinding

    private lateinit var mFragmentManager: FragmentManager
    private lateinit var animeListFragment: ListAnimeFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimeListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mFragmentManager = supportFragmentManager
        animeListFragment = ListAnimeFragment()


        var fragment = mFragmentManager.findFragmentByTag(ListAnimeFragment::class.java.simpleName)

        if(fragment !is ListAnimeFragment){
            mFragmentManager
                .beginTransaction()
                .add(R.id.container, animeListFragment, ListAnimeFragment::class.java.simpleName)
                .commit()
        }

    }

}