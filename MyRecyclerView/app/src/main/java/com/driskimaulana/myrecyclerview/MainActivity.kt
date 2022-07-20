package com.driskimaulana.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvHeroes: RecyclerView

    private var list: ArrayList<Hero> = arrayListOf()
    private var title: String = "Mode List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_heroes)

        rvHeroes.setHasFixedSize(true)

        list.addAll(HeroesData.listData)
        showRecyclerList()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return  super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(itemId: Int) {
        when(itemId){
            R.id.action_list -> {
                title = "Mode List"
                showRecyclerList()
            }

            R.id.action_grid -> {
                title = "Mode Grid"
                showRecyclerGrid()

            }

            R.id.action_cardView -> {
                title = "Mode CardView"
                showRecyclerCard()
            }
        }
        setActionBarTitle(title)
    }

    private fun showRecyclerCard() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val cardHeroAdapter = CardHeroAdapter(HeroesData.listData)
        rvHeroes.adapter = cardHeroAdapter
    }


    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter: ListHeroAdapter = ListHeroAdapter(list)

        rvHeroes.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallBack{
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })
    }

    private fun showRecyclerGrid()
    {
        rvHeroes.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter: GridHeroAdapter = GridHeroAdapter(HeroesData.listData)

        rvHeroes.adapter = gridHeroAdapter

        gridHeroAdapter.setOnItemClickCallback(object : GridHeroAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })
    }

    private fun setActionBarTitle(title: String)
    {
        supportActionBar?.title = title
    }

    private fun showSelectedHero(hero: Hero)
    {
        Toast.makeText(this, "${hero.name} is picked", Toast.LENGTH_SHORT).show()
    }
}