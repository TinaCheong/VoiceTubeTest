package com.tina.voicetubetest.extension

import androidx.fragment.app.Fragment
import com.tina.voicetubetest.VoiceTubeApplication
import com.tina.voicetubetest.factory.TimeViewModelFactory
import com.tina.voicetubetest.factory.ViewModelFactory

fun Fragment.getVmFactory(): ViewModelFactory {
    val repository = (requireContext().applicationContext as VoiceTubeApplication).voiceTubeRepository
    return ViewModelFactory(repository)
}

fun Fragment.getVmFactory(time: Int): TimeViewModelFactory {
    return TimeViewModelFactory(time)
}