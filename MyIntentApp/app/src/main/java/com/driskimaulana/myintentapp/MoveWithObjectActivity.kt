package com.driskimaulana.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_OBJECT = "extra_object"
    }

    private lateinit var tvObjectReceived: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        tvObjectReceived = findViewById(R.id.tvObjectReceived)

        var person = intent.getParcelableExtra<Person>(EXTRA_OBJECT)

        tvObjectReceived.text = "Name: ${person?.name}\nAge: ${person?.age}\nEmail: ${person?.email}\nCity: ${person?.city}"

    }
}