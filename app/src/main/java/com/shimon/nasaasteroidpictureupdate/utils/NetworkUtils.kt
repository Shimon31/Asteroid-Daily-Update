package com.shimon.nasaasteroidpictureupdate.utils

import com.shimon.nasaasteroidpictureupdate.data.local.Asteroid
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun parseAsteroidJsonResult(jsonObject: JSONObject): ArrayList<Asteroid> {

    val nearEarthObjects = jsonObject.getJSONObject("near_earth_objects")

    val asteroidList = ArrayList<Asteroid>()
    val next7Days = get7DaysList()

    for (dateFormat in next7Days) {

        if (nearEarthObjects.has(dateFormat)) {

            val dateWiseData = nearEarthObjects.getJSONArray(dateFormat)


            for (index in 0 until dateWiseData.length()) {

                val asteroidJson = dateWiseData.getJSONObject(index)
                val id = asteroidJson.getLong("id")
                val codeName = asteroidJson.getString("name")
                val closeApproachDate = asteroidJson
                    .getJSONArray("close_approach_data")
                    .getJSONObject(0).getString("close_approach_date")

                val isPotentiallyHazardous =
                    asteroidJson.getBoolean("is_potentially_hazardous_asteroid")

  
                val asteroid = Asteroid(

                    id = id,
                    codeName = codeName,
                    closeApproachDate = closeApproachDate,
                    absoluteMagnitude = 0.0,
                    estimatedDiameter = 0.0,
                    relativeVelocity = 0.0,
                    distanceFromEarth = 0.0,
                    isPotentiallyHazardous = isPotentiallyHazardous


                )

                asteroidList.add(asteroid)

            }

        }

    }
    return asteroidList

}

fun get7DaysList(): ArrayList<String> {

    val listOfDays = ArrayList<String>()
    val calender = Calendar.getInstance()

    for (i in 0..7) {

        val currentTime = calender.time
        val dateFormat = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault())

        listOfDays.add(dateFormat.format(currentTime))
        calender.add(Calendar.DAY_OF_YEAR, 1)

    }

    return listOfDays
}