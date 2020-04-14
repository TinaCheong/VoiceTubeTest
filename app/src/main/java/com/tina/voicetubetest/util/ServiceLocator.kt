package com.tina.voicetubetest.util

import android.content.Context
import androidx.annotation.VisibleForTesting
import com.tina.voicetubetest.data.source.DefaultVoiceTubeRepository
import com.tina.voicetubetest.data.source.VoiceTubeDataSource
import com.tina.voicetubetest.data.source.VoiceTubeRepository
import com.tina.voicetubetest.data.source.local.VoiceTubeLocalDataSource
import com.tina.voicetubetest.data.source.remote.VoiceTubeRemoteDataSource

object ServiceLocator {

    @Volatile
    var voiceTubeRepository:VoiceTubeRepository? = null
        @VisibleForTesting set

    fun provideTasksRepository(context: Context): VoiceTubeRepository {
        synchronized(this) {
            return voiceTubeRepository
                ?: voiceTubeRepository
                ?: createLineTVRepository(context)
        }
    }

    private fun createLineTVRepository(context: Context): VoiceTubeRepository {
        return DefaultVoiceTubeRepository(
           VoiceTubeRemoteDataSource,
            createLocalDataSource(context)
        )
    }

    private fun createLocalDataSource(context: Context): VoiceTubeDataSource {
        return VoiceTubeLocalDataSource(context)
    }
}