package com.example.MYASSIGNMENT

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // code the user interface by adding EditText!, Button! and TextView!
        val inputTime = findViewById<EditText>(R.id.inputTime)
        val suggestButton = findViewById<Button>(R.id.suggestButton)
        val resultText = findViewById<TextView>(R.id.resultText)
        val resetButton = findViewById<Button>(R.id.resetButton)

        // add code that happens when the button is clicked
        suggestButton.setOnClickListener {
            val time = inputTime.text.toString().toIntOrNull()

            if (time == null || time !in 0..23) {
                resultText.text = "Error! Try again"
            } else {
                val mealSuggestion = if (time in 5..10) {
                    "Breakfast: Pancakes, egg wrap, or fruit breakfast bowl!"
                } else if (time in 11..15) {
                    "Lunch: Sandwich, kota, or salad!"
                } else if (time in 16..20) {
                    "Dinner: Steak, chicken and rice, or stew and pap!"
                } else {
                    "Snack: Cookies, fruits, or a smoothie!"
                }

                resultText.text = mealSuggestion
            }
            // Reset button functionality
            resetButton.setOnClickListener {
                // Clear the input field and the meal suggestion
                inputTime.text.clear()
                suggestButton.text = ""
            }
        }
    }
}
