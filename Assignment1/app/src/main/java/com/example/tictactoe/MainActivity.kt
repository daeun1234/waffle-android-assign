package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel1: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonText = arrayOf(binding.c1, binding.c2, binding.c3, binding.c4, binding.c5, binding.c6, binding.c7, binding.c8, binding.c9)

        for ((index, button) in buttonText.withIndex()) {
            button.setOnClickListener{
                viewModel1.checkValue(index)
            }
        }

        viewModel1.dataList.observe(this, {
            for (i in 0..8) {
                buttonText[i].text = it[i]
            }
            viewModel1.showResult(binding.c1.text.toString(), binding.c2.text.toString(), binding.c3.text.toString(),
                binding.c4.text.toString(), binding.c5.text.toString(), binding.c6.text.toString(),
                binding.c7.text.toString(), binding.c8.text.toString(), binding.c9.text.toString())
        }
        )

        viewModel1.state.observe(this, {
            binding.state.text = it.toString()
        })

        binding.restartButton.setOnClickListener {
            viewModel1.checkValue(10)
        }
    }

}