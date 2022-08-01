package com.driskimaulana.backgroundthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.driskimaulana.backgroundthread.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Main) {
                try {
//                    simulati thread
                    for (i in 0..10) {
                        delay(500)
                        val percentage = i * 10
                        withContext(Dispatchers.Main) {
                            if (percentage == 100) {
                                binding.tvStatus.text = "Task Completed"
                            } else {
                                binding.tvStatus.text = "Extracting ${percentage.toString()}%"
                            }
                        }
                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }

    }
}