package com.shimon.nasaasteroidpictureupdate.data.remote.Api

import com.shimon.nasaapi.utils.Constant.API_Key
import com.shimon.nasaapi.utils.Constant.Base_Url
import com.shimon.nasaasteroidpictureupdate.data.models.ResponsePictureOfTheDay
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface AsteroidService {

    @GET("neo/rest/v1/feed")

    suspend fun getAsteroid(@Query("api_key") apikey: String = API_Key) : Response<String>

}

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

object AsteroidNetwork {

    private val retrofit = Retrofit.Builder()
        .baseUrl(Base_Url)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

    val asteroidService = retrofit.create(AsteroidService::class.java)

}