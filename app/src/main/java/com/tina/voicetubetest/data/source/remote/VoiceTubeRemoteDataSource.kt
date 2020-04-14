package com.tina.voicetubetest.data.source.remote

import androidx.lifecycle.LiveData
import com.tina.voicetubetest.data.Result
import com.tina.voicetubetest.data.VideoResult
import com.tina.voicetubetest.data.Videos
import com.tina.voicetubetest.data.source.VoiceTubeDataSource

object VoiceTubeRemoteDataSource : VoiceTubeDataSource{

    override suspend fun getVideoByNetwork(): Result<VideoResult> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getVideoByDatabase(): LiveData<List<Videos>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}