package com.doniapr.footballleague

import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {
    companion object {
        val EXTRA_LEAGUE = "extra_league"
        lateinit var league: League
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        league = intent.getParcelableExtra(EXTRA_LEAGUE)
        scrollView {
            verticalLayout {
                padding = dip(16)
                lparams(matchParent, wrapContent)
                orientation = LinearLayout.VERTICAL

                imageView {
                    scaleType = ImageView.ScaleType.FIT_XY
                    league.image?.let { Glide.with(this@DetailActivity).load(it).into(this) }
                }.lparams {
                    width = dip(200)
                    height = dip(200)
                    this.bottomMargin = dip(8)
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                textView {
                    text = league.name
                    textSize = 16F
                    typeface = Typeface.DEFAULT_BOLD
                }.lparams {
                    width = wrapContent
                    height = wrapContent
                    this.bottomMargin = dip(16)
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                textView {
                    text = league.description
                }.lparams {
                    width = matchParent
                    height = wrapContent
                }
            }
        }
    }
}
