package com.tina.voicetubetest.factory

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tina.voicetubetest.MainViewModel
import com.tina.voicetubetest.data.source.VoiceTubeRepository
import com.tina.voicetubetest.video.VideoListViewModel

//@Suppress("UNCHECKED_CAST")
//class VideoListViewModelFactory constructor(
//    private val lifecycleOwner: LifecycleOwner,
//    private val voiceTubeRepository: VoiceTubeRepository
//) : ViewModelProvider.NewInstanceFactory() {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>) =
//        with(modelClass) {
//            when {
//                isAssignableFrom(VideoListViewModel::class.java) ->
//                    VideoListViewModel(lifecycleOwner, voiceTubeRepository)
//
//                else ->
//                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
//            }
//        } as T
//}