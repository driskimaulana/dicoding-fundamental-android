package com.driskimaulana.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class MoveForResultActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnPilih : Button
    private lateinit var rgNumber : RadioGroup

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

//        initialize views
        btnPilih = findViewById(R.id.btnPilih)
        rgNumber = findViewById(R.id.radioGroup)

        btnPilih.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.btnPilih -> {
                if(rgNumber.checkedRadioButtonId > 0)
                {
                    var value = 110
                    when(rgNumber.checkedRadioButtonId)
                    {
                        R.id.rb_50 -> value = 50
                        R.id.rb_100 -> value = 100
                        R.id.rb_150 -> value = 150
                        R.id.rb_200 -> value = 200
                    }

                    val intent = Intent()
                    intent.putExtra(EXTRA_SELECTED_VALUE, value)
                    setResult(RESULT_CODE, intent)
                    finish()
                }
            }
        }
    }
}