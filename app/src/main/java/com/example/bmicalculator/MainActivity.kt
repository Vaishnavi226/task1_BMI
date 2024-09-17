package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val calcBtn = findViewById<Button>(R.id.clcBtn)

        // Set up button click listener
        calcBtn.setOnClickListener {
            calculateBMI()
        }




    }


    private fun calculateBMI() {
        // Assuming these are declared in your activity or fragment
        val weightEditText = findViewById<EditText>(R.id.edtWeight)
        val heightEditText = findViewById<EditText>(R.id.edtHeight)
        val resultTextView = findViewById<TextView>(R.id.resultTxt)

        // Retrieve input values
        val weight = weightEditText.text.toString().toFloatOrNull()
        val height = heightEditText.text.toString().toFloatOrNull()

        if (weight != null && height != null && height > 0) {
            // Calculate BMI
            val bmi = weight / (height / 100).pow(2)
            val bmiResult = String.format("%.2f", bmi)

            // Determine BMI category
            val bmiCategory = when {
                bmi < 18.5 -> "Underweight"
                bmi < 25 -> "Normal Weight"
                bmi < 30 -> "Overweight"
                else -> "Obese"
            }

            // Display result
            resultTextView.text = "BMI: $bmiResult\nCategory: $bmiCategory"
        } else {
            // Handle invalid input
            resultTextView.text = "Invalid Input"
        }
    }

//    private fun calculateBMI(){
//        val weight = R.id.edtWeight.toString().toFloatOrNull()
//        val height = R.id.edtHeight.toString().toFloatOrNull()
//
//        if(weight != null && height != null){
//            val bmi = weight/(height/100).pow(2)
//            val bmiResult = String.format("%.2f",bmi)
//
//
//            val bmiCategory = when{
//                bmi< 18.5 -> "Underweight"
//                bmi < 25 -> "Normal Weight"
//                bmi < 30 -> "Overweight"
//                else -> "Obese"
//            }
//
//            R.id.resultTxt. = "BMI: $bmiResult\nCategory: $bmiCategory"
//        }
//        else{
//            R.id.resultTxt = "Invalid Input"
//        }
//    }
}

