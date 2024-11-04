package com.shimon.nasaasteroidpictureupdate.data.remote.Api

import com.shimon.nasaapi.utils.Constant.API_Key
import com.shimon.nasaapi.utils.Constant.Base_Url
import com.shimon.nasaasteroidpictureupdate.data.models.ResponsePictureOfTheDay
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface AsteroidImageOfTheDayService {

    @GET("planetary/apod")

    suspend fun getImageOfTheDay(@Query("api_key") apikey: String = API_Key) : Response<ResponsePictureOfTheDay>

}

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

object Network {

    private val retrofit = Retrofit.Builder()
        .baseUrl(Base_Url)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val imageOfTheDayService = retrofit.create(AsteroidImageOfTheDayService::class.java)
}