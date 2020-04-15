package com.tina.voicetubetest.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tina.voicetubetest.MainViewModel
import com.tina.voicetubetest.data.source.VoiceTubeRepository
import com.tina.voicetubetest.video.VideoListViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val voiceTubeRepository: VoiceTubeRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(MainViewModel::class.java) ->
                    MainViewModel(voiceTubeRepository)

                isAssignableFrom(VideoListViewModel::class.java) ->
                    VideoListViewModel(voiceTubeRepository)

                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}