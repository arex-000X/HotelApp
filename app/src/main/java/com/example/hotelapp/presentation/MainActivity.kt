package com.example.hotelapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hotelapp.R

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ViewModelHotel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[ViewModelHotel::class.java]

        viewModel.getResponce().observe(this){
            Log.d("HotelRepository", "getHotelRes -> Data Api: ${it} ")
        }
        viewModel.getHotelList().observe(this){
            Log.d("HotelRepository", "getHotellist -> Data Api: ${it}")
        }
        viewModel.getHotel().observe(this){
            Log.d("HotelRepository", "getHotel -> Data Api: ${it}")
        }

    }
}