package com.example.hotelapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hotelapp.domain.HotelResponce
import com.example.hotelapp.domain.HotelRepository
import com.example.hotelapp.domain.Hotels
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

object HotelRepositoryImpl : HotelRepository {

    private var hotelResApi: MutableLiveData<HotelResponce> = MutableLiveData()
    private var hotelsList: MutableLiveData<List<Hotels>> = MutableLiveData()
    private var id:Int = 0
    val compositedisposable = CompositeDisposable()
    override fun getHoteResponce(): LiveData<HotelResponce> {
        val disposable = ApiFactory.apiService
            .getHotelResponce()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                hotelResApi.value = it
                hotelsList.value = it.results.hotels
                for (i in hotelResApi.value!!.results.hotels){
                    id = i.id
                }
            }, {
                Log.d("HotelRepository", "getHoteRes -> Error: ${it.message} ")
            })
        compositedisposable.add(disposable)
        return hotelResApi

    }
    override fun getHotelList(): LiveData<List<Hotels>> {
      return hotelsList
    }
    override fun getHotel(): LiveData<Hotels> {
        val hotels = MutableLiveData<Hotels>()
        val disposable = ApiFactory.apiService.getHotelitem(333578)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            hotels.value = it
        },{
            Log.d("HotelRepository", "getHoteRes -> Error: ${it.message} ")
        })
        compositedisposable.add(disposable)
      return hotels
    }

}