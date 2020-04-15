package com.tina.voicetubetest.data.source.remote

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.tina.voicetubetest.data.Result
import com.tina.voicetubetest.data.VideoResult
import com.tina.voicetubetest.data.Videos
import com.tina.voicetubetest.data.source.VoiceTubeDataSource
import com.tina.voicetubetest.network.VoiceTubeApi
import com.tina.voicetubetest.util.Logger

object VoiceTubeRemoteDataSource : VoiceTubeDataSource{

    override suspend fun getVideoByNetwork(): Result<VideoResult> {

        val getResultDeferred = VoiceTubeApi.RETROFIT_SERVICE.getVideoList()
        return try {
            val listResult = getResultDeferred.await()
            Result.Success(listResult)

        } catch (e: Exception) {
            Logger.w("[${this::class.simpleName}] exception=${e.message}")
            Result.Error(e)
        }
    }

    override fun getVideoByDatabase(): DataSource.Factory<Int, Videos> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun insertVideos(videos: Videos) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}