package com.example.hotelapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelapp.R
import com.example.hotelapp.presentation.adapter.HotelsAdapter
import com.example.hotelapp.presentation.fragments.viewmodel.ViewModelHotel

class FragmentHotelList : Fragment() {

    lateinit var viewModel: ViewModelHotel
    lateinit var adapter: HotelsAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater
            .inflate(R.layout.fragment_hotel_list, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HotelsAdapter()
        recyclerView = view.findViewById(R.id.recylerview)
        recyclerView.adapter = adapter
        viewModel = ViewModelProvider(this)[ViewModelHotel::class.java]
        viewModel.getHotelList().observe(viewLifecycleOwner) {
            Log.d("HotelRepository", "getHotellist -> Data Api: ${it}")
            adapter.hotels = it
        }
        adapter.hotelItemClickListener = {
            viewModel.getHotel(it).observe(viewLifecycleOwner) {
                Log.d("HotelRepository", "getHotel -> Data Api: ${it.results.hotels}")
            }
        }
    }


}