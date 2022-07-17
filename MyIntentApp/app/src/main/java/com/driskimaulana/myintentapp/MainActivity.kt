
package com.driskimaulana.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnPindah : Button
    private lateinit var btnPindahData : Button
    private lateinit var btnPindahObject : Button
    private lateinit var btnDialNumber : Button
    private lateinit var btnPindahResult : Button

    private lateinit var tvHasilActivity : TextView

    private val resultLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        result ->
        if(result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null)
        {
            val selectedValue = result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvHasilActivity.text = "Hasil: ${selectedValue.toString()}"
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        btnPindah.setOnClickListener(this)
        btnPindahData.setOnClickListener(this)
        btnPindahObject.setOnClickListener(this)

        btnDialNumber.setOnClickListener(this)
        btnPindahResult.setOnClickListener(this)

        tvHasilActivity.setOnClickListener(this)

    }

    private fun initViews() {
        btnPindah = findViewById(R.id.btnPindah)
        btnPindahData = findViewById(R.id.btnPindahData)
        btnPindahObject = findViewById(R.id.btnPindahObject)
        btnPindahResult = findViewById(R.id.btnPindahResult)
        btnDialNumber = findViewById(R.id.btnDialNumber)

        tvHasilActivity = findViewById(R.id.tvHasilActivity)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnPindah -> {
                val intent = Intent(this@MainActivity, MoveActivity::class.java)

                startActivity(intent)
            }
            R.id.btnPindahData -> {
                val intent = Intent(this@MainActivity, MoveWithDataActivity::class.java)

                intent.putExtra(MoveWithDataActivity.EXTRA_NAME, "D'Riski Maulana")
                intent.putExtra(MoveWithDataActivity.EXTRA_AGE, 20)

                startActivity(intent)
            }
            R.id.btnPindahObject -> {
                val intent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)

                intent.putExtra(MoveWithObjectActivity.EXTRA_OBJECT, Person("D'Riski Maulana", 20, "driskimaulana@upi.edu", "Garut"))

                startActivity(intent)
            }

            R.id.btnDialNumber -> {
                val phoneNumber = "085156087141"
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(intent)
            }

            R.id.btnPindahResult -> {
                val moveForResultIntent = Intent(this@MainActivity, MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }

        }
    }


}