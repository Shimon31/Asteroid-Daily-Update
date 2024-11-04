package com.shimon.nasaasteroidpictureupdate.views.Home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shimon.nasaasteroidpictureupdate.data.models.ResponsePictureOfTheDay
import com.shimon.nasaasteroidpictureupdate.data.remote.Api.Network
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel() {


    private val _imageOfTheDay = MutableLiveData<ResponsePictureOfTheDay>()
    val imageOfTheDay: LiveData<ResponsePictureOfTheDay> = _imageOfTheDay


    init {
        getImageOfTheDay()
    }

    private fun getImageOfTheDay() {
        viewModelScope.launch {

            val response = Network.imageOfTheDayService.getImageOfTheDay()
            if (response.isSuccessful){

                _imageOfTheDay.postValue(response.body())

            }

        }
    }


}
