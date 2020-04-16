package com.tina.voicetubetest.settimer

import androidx.databinding.InverseMethod
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SetTimerViewModel (var time: Int) : ViewModel(){

    private val _setTime = MutableLiveData<Int>().apply {
        value = time
    }
    val setTime: LiveData<Int>
        get() = _setTime

    private val _navigateToTimer = MutableLiveData<Int>()

    val navigateToTimer: LiveData<Int>
        get() = _navigateToTimer

    fun navigateToFinish() {
        _navigateToTimer.value = _setTime.value
    }

    fun onFinishNavigated() {
        _navigateToTimer.value = null
    }

    init {
        _setTime.value = 0
    }


    fun convertStringToInt(value: String): Int {
        return try {
            value.toInt()
        } catch (e: NumberFormatException) {
            1
        }
    }

    @InverseMethod("convertIntToString")
    fun convertIntToString(value: Int?): String {
        return value?.toString() ?: ""
    }




}