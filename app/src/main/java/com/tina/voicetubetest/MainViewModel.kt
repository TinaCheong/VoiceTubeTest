package com.tina.voicetubetest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tina.voicetubetest.data.source.VoiceTubeRepository
import com.tina.voicetubetest.util.CurrentFragmentType

class MainViewModel (private val voiceTubeRepository: VoiceTubeRepository) : ViewModel(){

    val currentFragmentType = MutableLiveData<CurrentFragmentType>()

}