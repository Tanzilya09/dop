package com.example.dop

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.dop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var viewModel: MainViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setUpObserves()
        setUpListen()
    }

    private fun setUpObserves() {
        viewModel?.number?.observe(this){
            binding.countTxt.text=it.toString()
        }
    }

    private fun setUpListen() {
        binding.plusBtn.setOnClickListener{
            viewModel?.setPlus()
            when(viewModel?.count){
                10,-10->{ binding.countTxt.setTextColor(Color.BLUE)}
                else->{ binding.countTxt.setTextColor(Color.BLACK)}
            }
        }
        binding.minusBtn.setOnClickListener{
            viewModel?.setMinus()
            when(viewModel?.count){
                10,-10->{ binding.countTxt.setTextColor(Color.BLUE)}
                else->{ binding.countTxt.setTextColor(Color.BLACK)}
            }
        }
    }

}