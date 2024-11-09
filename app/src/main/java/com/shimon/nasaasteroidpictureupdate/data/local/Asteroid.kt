package com.shimon.nasaasteroidpictureupdate.data.local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Asteroid(

    val id: Long,
    val codeName: String,
    val closeApproachDate: String,
    val absoluteMagnitude: Double,
    val estimatedDiameter: Double,
    val relativeVelocity: Double,
    val distanceFromEarth: Double,
    val isPotentiallyHazardous: Boolean

) : Parcelable
