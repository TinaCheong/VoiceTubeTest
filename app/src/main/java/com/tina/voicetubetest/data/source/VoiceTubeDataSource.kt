package com.tina.voicetubetest.data.source

import androidx.lifecycle.LiveData
import com.tina.voicetubetest.data.Result
import com.tina.voicetubetest.data.VideoResult
import com.tina.voicetubetest.data.Videos

interface VoiceTubeDataSource {

    suspend fun getVideoByNetwork(): Result<VideoResult>

    fun getVideoByDatabase(): LiveData<List<Videos>>

    suspend fun insertVideos(videos: Videos)
}