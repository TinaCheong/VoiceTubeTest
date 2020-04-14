package com.tina.voicetubetest.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tina.voicetubetest.data.Videos

@Dao
interface VideoDatabaseDao {

    @Insert
    fun saveVideos(videos: Videos)

    @Query("SELECT * FROM video_list_table")
    fun getAllVideos(): LiveData<List<Videos>>

}