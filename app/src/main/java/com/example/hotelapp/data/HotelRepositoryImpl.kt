package com.example.hotelapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hotelapp.domain.HotelResponce
import com.example.hotelapp.domain.HotelRepository
import com.example.hotelapp.domain.Hotels
import com.example.hotelapp.domain.Results
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

object HotelRepositoryImpl : HotelRepository {

    private var hotelResApi: MutableLiveData<HotelResponce> = MutableLiveData()
    private var hotelsList: MutableLiveData<List<Hotels>> = MutableLiveData()
    private var hotels: MutableLiveData<HotelResponce> = MutableLiveData()
    private var id: Int = 0
    val compositedisposable = CompositeDisposable()
    override fun getHoteResponce(): LiveData<HotelResponce> {
        val disposable = ApiFactory
            .apiService
            .getHotelResponce("Moscow")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                     hotelResApi.value = it
                     hotelsList.value = it.results.hotels
            },{

            })
        compositedisposable.add(disposable)
        return hotelResApi
    }

    override fun getHotel(): LiveData<HotelResponce> {
        val disposable = ApiFactory
            .apiService
            .getHotelResponce(333526)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                hotels.value = it

            },{

            })
        compositedisposable.add(disposable)
        return hotels
    }



    override fun getHotelList(): LiveData<List<Hotels>> {
        return hotelsList
    }


}