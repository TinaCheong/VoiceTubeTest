package com.tina.voicetubetest.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tina.voicetubetest.settimer.SetTimerViewModel
import com.tina.voicetubetest.timer.TimerViewModel

@Suppress("UNCHECKED_CAST")
class TimeViewModelFactory(
    private val time: Int
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(TimerViewModel::class.java) ->
                    TimerViewModel(time)

                isAssignableFrom(SetTimerViewModel::class.java) ->
                    SetTimerViewModel(time)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}