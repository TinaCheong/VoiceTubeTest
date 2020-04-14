package com.tina.voicetubetest.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VideoResult(
    val status: String = "",
    @Json(name = "videos")
    val videoList: List<Videos> = listOf()
): Parcelable