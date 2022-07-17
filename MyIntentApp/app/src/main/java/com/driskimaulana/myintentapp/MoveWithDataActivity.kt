package com.driskimaulana.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MoveWithDataActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    private lateinit var tvDataReceived: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        tvDataReceived = findViewById(R.id.tvDataReceived)

        var extraName = intent.getStringExtra(EXTRA_NAME)
        var extraAge = intent.getIntExtra(EXTRA_AGE, 0)

        tvDataReceived.text = "Name: ${extraName} | Age: ${extraAge}"

    }
}