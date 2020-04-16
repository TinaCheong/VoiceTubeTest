package com.tina.voicetubetest.timer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerViewModel (var time: Int): ViewModel(){

    private val _setTime = MutableLiveData<Int>().apply {
        value = time
    }
    val setTime: LiveData<Int>
        get() = _setTime

}