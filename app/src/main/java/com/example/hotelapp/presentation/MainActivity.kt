package com.example.hotelapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hotelapp.R
import com.example.hotelapp.presentation.fragments.FragmentHotelList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view,FragmentHotelList()).commit()
    }
}