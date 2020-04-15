package com.tina.voicetubetest.data.source

import android.speech.tts.Voice
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import com.tina.voicetubetest.data.Result
import com.tina.voicetubetest.data.VideoResult
import com.tina.voicetubetest.data.Videos

class DefaultVoiceTubeRepository(private val voiceTubeRemoteDataSource: VoiceTubeDataSource,
                                 private val voiceTubeLocalDataSource: VoiceTubeDataSource) : VoiceTubeRepository {

    override suspend fun getVideoByNetwork(): Result<VideoResult> {
        return voiceTubeRemoteDataSource.getVideoByNetwork()
    }

    override fun getVideoByDatabase(): LiveData<List<Videos>> {
        return voiceTubeLocalDataSource.getVideoByDatabase()
    }

    override suspend fun insertVideos(videos: Videos) {
        return voiceTubeLocalDataSource.insertVideos(videos)
    }
}