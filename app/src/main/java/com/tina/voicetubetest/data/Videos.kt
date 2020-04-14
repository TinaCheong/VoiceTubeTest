package com.tina.voicetubetest.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "video_list_table")
data class Videos(
    @PrimaryKey(autoGenerate = true)
    val autoId: Int = 0,
    @ColumnInfo(name = "video_title")
    val title: String = "",
    @ColumnInfo(name = "video_image")
    val img: String = ""
):Parcelable