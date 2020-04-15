package com.tina.voicetubetest.extension

import android.app.Activity
import com.tina.voicetubetest.VoiceTubeApplication
import com.tina.voicetubetest.factory.ViewModelFactory

fun Activity.getVmFactory(): ViewModelFactory {
    val repository = (applicationContext as VoiceTubeApplication).voiceTubeRepository
    return ViewModelFactory(repository)
}