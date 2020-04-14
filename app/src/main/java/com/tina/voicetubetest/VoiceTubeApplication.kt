package com.tina.voicetubetest

import android.app.Application
import com.tina.voicetubetest.data.source.VoiceTubeRepository
import com.tina.voicetubetest.util.ServiceLocator
import kotlin.properties.Delegates

class VoiceTubeApplication : Application() {

    val voiceTubeRepository: VoiceTubeRepository
        get() = ServiceLocator.provideTasksRepository(this)

    companion object {
        var INSTANCE: VoiceTubeApplication by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}