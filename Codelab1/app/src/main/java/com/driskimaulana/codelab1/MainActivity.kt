package com.driskimaulana.codelab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var txtEdtPanjang : EditText
    private lateinit var txtEdtLebar : EditText
    private lateinit var txtEdtTinggi : EditText
    private lateinit var btnHitung : Button

    private lateinit var txtHitung : TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        btnHitung.setOnClickListener(this)


        if(savedInstanceState != null)
        {
            val result = savedInstanceState.getString(STATE_RESULT)
            txtHitung.text = result
        }
    }

    private fun initView() {

        txtEdtLebar = findViewById(R.id.edtTxtLebar)
        txtEdtPanjang = findViewById(R.id.edtTxtPanjang)
        txtEdtTinggi = findViewById(R.id.edtTxtTinggi)

        btnHitung = findViewById(R.id.btnHitung)

        txtHitung = findViewById(R.id.txtHasil)


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnHitung -> {
                val lebar : String = txtEdtLebar.text.toString().trim()
                val panjang : String = txtEdtPanjang.text.toString().trim()
                val tinggi : String = txtEdtTinggi.text.toString().trim()

                var isThereEmptyFields = false

                if(lebar.isEmpty())
                {
                    isThereEmptyFields = true

                    txtEdtLebar.error = "Please enter some number!"
                }

                if(panjang.isEmpty())
                {
                    isThereEmptyFields = true

                    txtEdtPanjang.error = "Please enter some number!"
                }

                if(tinggi.isEmpty())
                {
                    isThereEmptyFields = true

                    txtEdtTinggi.error = "Please enter some number!"
                }

                if(!isThereEmptyFields)
                {
                    txtHitung.text = (panjang.toDouble() * lebar.toDouble() * tinggi.toDouble()).toString()
                }


            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, txtHitung.text.toString())
    }
}