package com.code95.amfloatingmenu

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_am_floating_menu.*

class AMFloatingMenuActivity : AppCompatActivity() {

    var isOpen: Boolean = false
    var dpWidth: Float = 0f
    var dpHeight: Float = 0f
    var SCREEN_CENTER_WIDTH: Float = 0f
    var SCREEN_CENTER_HIEGTH: Float = 0f
    var COLLAPSE_DURITUIN: Long = 500

    var floatingx: Float = 0f
    var floatingy: Float = 0f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_am_floating_menu)


        val displayMetrics: DisplayMetrics = resources.displayMetrics
        dpHeight = displayMetrics.heightPixels.toFloat()
        dpWidth = displayMetrics.widthPixels.toFloat()

//        Toast.makeText(this, "Width = " + dpWidth + "Hight = " + dpHeight, Toast.LENGTH_LONG).show()


        SCREEN_CENTER_WIDTH = dpWidth / 2.6F
        SCREEN_CENTER_HIEGTH = dpHeight / 2.6F

        floatingx = floatingActionButton.x
        floatingy = floatingActionButton.y



        floatingActionButton.setOnClickListener {
            if (isOpen) {
                isOpen = false
                collapseFloating()
                floatingCL.background = null
                floatingCL.visibility = View.GONE
            } else {
                floatingCL.visibility = View.VISIBLE
                floatingActionButton
                    .animate()
                    .translationX(0f)
                    .translationY(-SCREEN_CENTER_HIEGTH)
                    .setDuration(300)
                    .withEndAction {
                        expandFloating()
                    }
                    .start()
//                floatingCL.backgroundColor = ContextCompat.getColor(this, R.color.grey_tranparent)
                isOpen = true
            }
        }
    }


    fun collapseFloating() {
        homeTV.animate()
            .translationXBy(-dpWidth / 15f)
            .translationYBy(dpHeight / 4f)
            .setDuration(COLLAPSE_DURITUIN)
            .withEndAction {
                homeTV.visibility = View.GONE
            }
            .start()

        locationsTV.animate()
            .translationXBy(dpWidth / 12f)
            .translationYBy(dpHeight / 6f)
            .setDuration(COLLAPSE_DURITUIN)
            .withEndAction {
                locationsTV.visibility = View.GONE
            }
            .start()

        findDoctorsTV.animate()
            .translationXBy(dpWidth / 6f)
            .translationYBy(dpHeight / 12f)
            .setDuration(COLLAPSE_DURITUIN)
            .withEndAction {
                findDoctorsTV.visibility = View.GONE
            }
            .start()

        bookingTV.animate()
            .translationXBy(dpWidth / 4f)
            .translationYBy(dpHeight / 200f)
            .setDuration(COLLAPSE_DURITUIN)
            .withEndAction {
                bookingTV.visibility = View.GONE
            }
            .start()

        servicesTV.animate()
            .translationXBy(dpWidth / 6f)
            .translationYBy(-dpHeight / 12f)
            .setDuration(COLLAPSE_DURITUIN)
            .withEndAction {
                servicesTV.visibility = View.GONE
            }
            .start()

        blogTV.animate()
            .translationXBy(dpWidth / 12f)
            .translationYBy(-dpHeight / 6f)
            .setDuration(COLLAPSE_DURITUIN)
            .withEndAction {
                blogTV.visibility = View.GONE
            }
            .start()

        settingsTV.animate()
            .translationXBy(-dpWidth / 15f)
            .translationYBy(-dpHeight / 4f)
            .setDuration(COLLAPSE_DURITUIN)
            .withEndAction {
                settingsTV.visibility = View.GONE
                floatingActionButton
                    .animate()
                    .translationY(floatingx)
                    .translationX(floatingy)
                    .setDuration(300)
                    .withEndAction {
                    }
                    .start()

            }
            .start()
    }

    fun expandFloating() {
        homeTV.animate()
            .translationXBy(dpWidth / 15f)
            .translationYBy(-dpHeight / 4f)
            .setDuration(700)
            .withStartAction {
                homeTV.visibility = View.VISIBLE
            }
            .start()

        locationsTV.animate()
            .translationXBy(-dpWidth / 12f)
            .translationYBy(-dpHeight / 6f)
            .setDuration(750)
            .withStartAction {
                locationsTV.visibility = View.VISIBLE
            }
            .start()

        findDoctorsTV.animate()
            .translationXBy(-dpWidth / 6f)
            .translationYBy(-dpHeight / 12f)
            .setDuration(800)
            .withStartAction {
                findDoctorsTV.visibility = View.VISIBLE
            }
            .start()

        bookingTV.animate()
            .translationXBy(-dpWidth / 4f)
            .translationYBy(-dpHeight / 200f)
            .setDuration(850)
            .withStartAction {
                bookingTV.visibility = View.VISIBLE
            }
            .start()

        servicesTV.animate()
            .translationXBy(-dpWidth / 6f)
            .translationYBy(dpHeight / 12f)
            .setDuration(900)
            .withStartAction {
                servicesTV.visibility = View.VISIBLE
            }
            .start()

        blogTV.animate()
            .translationXBy(-dpWidth / 12f)
            .translationYBy(dpHeight / 6f)
            .setDuration(950)
            .withStartAction {
                blogTV.visibility = View.VISIBLE
            }
            .start()

        settingsTV.animate()
            .translationXBy(dpWidth / 15f)
            .translationYBy(dpHeight / 4f)
            .setDuration(1000)
            .withStartAction {
                settingsTV.visibility = View.VISIBLE
            }
            .start()
    }

    override fun onBackPressed() {
        if (isOpen) {
            isOpen = false
            collapseFloating()
            floatingCL.background = null
            floatingCL.visibility = View.GONE
        } else {
            super.onBackPressed()
        }
    }
}
