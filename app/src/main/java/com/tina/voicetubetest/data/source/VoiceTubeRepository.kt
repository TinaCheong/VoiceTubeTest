package com.tina.voicetubetest.data.source

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import com.tina.voicetubetest.data.Result
import com.tina.voicetubetest.data.VideoResult
import com.tina.voicetubetest.data.Videos

interface VoiceTubeRepository {

    suspend fun getVideoByNetwork(): Result<VideoResult>

    fun getVideoByDatabase():LiveData<List<Videos>>

    suspend fun insertVideos(videos: Videos)
}