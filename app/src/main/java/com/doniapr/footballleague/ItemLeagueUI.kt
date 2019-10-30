package com.doniapr.footballleague

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import org.jetbrains.anko.*

class ItemLeagueUI : AnkoComponent<ViewGroup> {

    companion object {
        const val txt_name: Int = 1
        const val img_badge: Int = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        verticalLayout {
            padding = dip(14)
            this.orientation = LinearLayout.VERTICAL
            this.gravity = Gravity.CENTER_HORIZONTAL
            imageView {
                id = img_badge
                scaleType = ImageView.ScaleType.FIT_XY
            }.lparams {
                width = dip(70)
                height = dip(70)
            }
            textView {
                id = txt_name
            }.lparams {
                this.gravity = Gravity.CENTER
            }
        }
    }
}
