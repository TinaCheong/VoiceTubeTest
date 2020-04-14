package com.tina.voicetubetest.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Videos(
    val title: String = "",
    val img: String = ""
):Parcelable