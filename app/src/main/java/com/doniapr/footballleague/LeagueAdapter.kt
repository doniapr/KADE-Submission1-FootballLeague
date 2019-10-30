package com.doniapr.footballleague

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class LeagueAdapter(private val league: List<League>, private val listener: (League) -> Unit) :
    RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LeagueViewHolder(
        ItemLeagueUI().createView(
            AnkoContext.Companion.create(parent.context, parent)
        )
    )

    override fun getItemCount() = league.size

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(league[position], listener)
    }

    class LeagueViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        val name: TextView = itemView.findViewById(ItemLeagueUI.txt_name)
        val imgBadge: ImageView = itemView.findViewById(ItemLeagueUI.img_badge)

        fun bindItem(league: League, listener: (League) -> Unit) {
            name.text = league.name
            league.image?.let { Glide.with(containerView).load(it).into(imgBadge) }
            containerView.setOnClickListener { listener(league) }
        }
    }
}