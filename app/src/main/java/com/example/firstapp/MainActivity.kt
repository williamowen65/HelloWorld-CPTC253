package com.example.firstapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
//    private lateinit var buttonLeft = findViewById<Button>(R.id.buttonLeft)
    private lateinit var buttonLeft: Button;
    private lateinit var buttonRight: Button;
    private var score = 0
    private lateinit var scoreBox : TextView
//    private Random rand;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        buttonLeft = findViewById(R.id.buttonLeft)
        buttonRight = findViewById(R.id.buttonRight)
        buttonLeft.text = Random.nextInt(100).toString()
        buttonRight.text = Random.nextInt(100).toString()

        scoreBox = findViewById(R.id.scoreBox)
    }

    fun onClick(v: View) {
       val leftText = buttonLeft.text.toString()
        val rightText = buttonRight.text.toString()
        if(v.equals(buttonLeft)){
            if(leftText.compareTo(rightText) > 0){
                score++
                Toast.makeText(this, "Correct", Toast.LENGTH_LONG).show()
            }  else {
                score--
                Toast.makeText(this, "Incorrect", Toast.LENGTH_LONG).show()
            }
        } else {
            if(leftText.compareTo(rightText) < 0){
                score++
                Toast.makeText(this, "Correct", Toast.LENGTH_LONG).show()
            }  else {
                score--
                Toast.makeText(this, "Incorrect", Toast.LENGTH_LONG).show()
            }
        }

        buttonLeft.text = Random.nextInt(100).toString()
        buttonRight.text = Random.nextInt(100).toString()

        scoreBox.setText("Points: $score");
    }
}