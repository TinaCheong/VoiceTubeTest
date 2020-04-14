package com.tina.voicetubetest.data.source.local

import android.content.Context
import androidx.lifecycle.LiveData
import com.tina.voicetubetest.data.Result
import com.tina.voicetubetest.data.VideoResult
import com.tina.voicetubetest.data.Videos
import com.tina.voicetubetest.data.source.VoiceTubeDataSource

class VoiceTubeLocalDataSource (private val context: Context) : VoiceTubeDataSource{

    override suspend fun getVideoByNetwork(): Result<VideoResult> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getVideoByDatabase(): LiveData<List<Videos>> {
        return VideoDatabase.getInstance(context).videoDatabaseDao.getAllVideos()
    }


}