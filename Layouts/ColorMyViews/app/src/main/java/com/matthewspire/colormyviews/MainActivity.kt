package com.matthewspire.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    /**
     * Attaches listeners to all the Views.
     */
    private fun setListeners() {
        // Use a listOf Views because we set the same click listener on each View
        val clickableViews: List<View> =
            listOf(box_one_text, box_two_text, box_three_text,
                box_four_text, box_five_text, constraint_layout)

        // Set the listener for each View
        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    /**
     * Sets the background color of a View depending on it's resource id.
     * This is a way of using onClickHandler to do similar operations on a group of Views.
     *
     * Demonstrates three different ways of setting colors.
     *     * Using a color constant from the Color class
     *     * Using an Android color resource
     *     * Using a custom color defined in color.xml
     */
    private fun makeColored(view: View) {
        // Every view has a resource ID (i.e., the ID we set earlier)
        when (view.id) {

            /**
             * Switch on the resource ID of the Views and pick a color depending on what the source
             * id is
             */

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            // User taps the background, which reveals the outline of other boxes to click as a hint
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}