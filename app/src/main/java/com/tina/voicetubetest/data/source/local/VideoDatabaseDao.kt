package com.tina.voicetubetest.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.tina.voicetubetest.data.Videos

@Dao
interface VideoDatabaseDao {

    @Query("SELECT * FROM video_list_table")
    fun getAllVideos(): LiveData<List<Videos>>

}