package com.example.hotelapp.data.repository

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hotelapp.data.api.ApiFactory
import com.example.hotelapp.domain.model.HotelResponce
import com.example.hotelapp.domain.repository.HotelRepository
import com.example.hotelapp.domain.model.Hotels
import com.example.hotelapp.domain.model.Results
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

object HotelRepositoryImpl : HotelRepository {

    private var hotelsList = MutableLiveData<List<Hotels>>()
    private var hotels = MutableLiveData<HotelResponce>()
    val compositedisposable = CompositeDisposable()
    @SuppressLint("SuspiciousIndentation")
    override fun getHotelList(): LiveData<List<Hotels>> {
      var disposable = ApiFactory.apiService
            .getHotelResponce("Estonia")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                hotelsList.postValue(it.results.hotels)

            }, {

            })
        compositedisposable.add(disposable)
        return hotelsList
    }

    override fun getHotel(id:Int): LiveData<HotelResponce> {
        var disposable = ApiFactory.apiService
            .getHotelResponce(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                hotels.postValue(it)
            }, {

            })
        compositedisposable.add(disposable)
        return hotels
    }
}