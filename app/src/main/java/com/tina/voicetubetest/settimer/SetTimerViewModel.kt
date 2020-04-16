package com.tina.voicetubetest.settimer

import androidx.databinding.InverseMethod
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SetTimerViewModel (var time: Int) : ViewModel(){

    var setTime = MutableLiveData<Int>().apply {
        value = time
    }

    private val _navigateToTimer = MutableLiveData<Int>()
    val navigateToTimer: LiveData<Int>
        get() = _navigateToTimer

    fun navigateToTimer() {
        _navigateToTimer.value = setTime.value
    }

    fun onFinishNavigated() {
        _navigateToTimer.value = null
    }

    init {
        setTime.value = 0
    }

    @InverseMethod("convertIntToString")
    fun convertStringToInt(value: String): Int {
        return try {
            value.toInt()
        } catch (e: NumberFormatException) {
            1
        }
    }
    fun convertIntToString(value: Int?): String {
        return value?.toString() ?: ""
    }

}