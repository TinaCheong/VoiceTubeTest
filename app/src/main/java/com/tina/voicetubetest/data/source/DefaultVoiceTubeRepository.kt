package com.tina.voicetubetest.data.source

import android.speech.tts.Voice
import androidx.lifecycle.LiveData
import com.tina.voicetubetest.data.Result
import com.tina.voicetubetest.data.VideoResult
import com.tina.voicetubetest.data.Videos

class DefaultVoiceTubeRepository(private val voiceTubeLocalDataSource: VoiceTubeDataSource,
                                 private val voiceTubeRemoteDataSource: VoiceTubeDataSource) : VoiceTubeRepository {

    override suspend fun getVideoByNetwork(): Result<VideoResult> {
        return voiceTubeRemoteDataSource.getVideoByNetwork()
    }

    override fun getVideoByDatabase(): LiveData<List<Videos>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}