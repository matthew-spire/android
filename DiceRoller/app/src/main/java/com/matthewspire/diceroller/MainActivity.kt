package com.matthewspire.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    // Use lateinit to extract the image view variable
    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Use findViewById to get a reference to the button and assign it to an immutable variable called rollButton
        val rollButton = findViewById<Button>(R.id.roll_button)
        // Dynamically modify the Button view - Set the button text to "Roll Button"
        rollButton.text = "Let's Roll"
        // Set the OnClickListener for the button
        rollButton.setOnClickListener {
            // Remove the Toast and create a method called rollDice
            rollDice()
        }

        // Initialize the image view variable
        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        // Write have the rollDice method to get a random number between 1 and 6
        val randomInt = Random.nextInt(6) + 1
        // Choose the right drawable resource based on the value of randomInt
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Assign the drawableResource from above to diceImage
        diceImage.setImageResource(drawableResource)
    }
}