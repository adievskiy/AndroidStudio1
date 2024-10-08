package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var result: TextView
    private lateinit var count: TextView
    private lateinit var inputText: EditText
    private lateinit var convert: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        result = findViewById(R.id.result)
        count = findViewById(R.id.count)
        inputText = findViewById(R.id.inputText)
        convert = findViewById(R.id.convert)

        onClickConvert(convert)
    }
    fun onClickConvert(view: View) {
        val input = inputText.text.toString()
        val reversed = input.reversed()
        result.text = reversed
        val deleteSpaces = input.filter { it != ' ' }
        val tmpCount = deleteSpaces.length
        count.text = tmpCount.toString()
    }
}