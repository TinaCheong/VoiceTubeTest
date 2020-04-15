package com.tina.voicetubetest.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bumptech.glide.load.engine.bitmap_recycle.IntegerArrayAdapter
import com.tina.voicetubetest.data.Videos

@Dao
interface VideoDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveVideos(videos: Videos)

    @Query("SELECT * FROM video_list_table ORDER BY autoId DESC")
    fun getAllVideos(): LiveData<List<Videos>>

}