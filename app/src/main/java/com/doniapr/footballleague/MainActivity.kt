package com.doniapr.footballleague

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {
    private var leagues: MutableList<League> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        verticalLayout {
            recyclerView {
                layoutManager = GridLayoutManager(context, 2)
                adapter = LeagueAdapter(leagues) {
                    startActivity<DetailActivity>(DetailActivity.EXTRA_LEAGUE to it)
                }
            }
        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.league_name)
        val image = resources.obtainTypedArray(R.array.league_badge)
        val description = resources.getStringArray(R.array.description)
        leagues.clear()

        for (i in name.indices) {
            leagues.add(League(name[i], image.getResourceId(i, 0), description[i]))
        }
        image.recycle()
    }
}
