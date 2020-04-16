package com.tina.voicetubetest.timer

import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tina.voicetubetest.VoiceTubeApplication

class TimerViewModel(var time: Int) : ViewModel() {

    private val _setTime = MutableLiveData<Int>().apply {
        value = time
    }
    val setTime: LiveData<Int>
        get() = _setTime

    private val _timeRemained = MutableLiveData<Int>()
    val timeRemained: LiveData<Int>
        get() = _timeRemained

    lateinit var countDownTimer: CountDownTimer

    companion object {
        const val SECOND_TO_MILLISECOND = 1000
    }

    private val _isCounting = MutableLiveData<Boolean>()
    val isCounting: LiveData<Boolean>
        get() = _isCounting

    private val _isPaused = MutableLiveData<Boolean>()
    val isPaused: LiveData<Boolean>
        get() = _isPaused

    init {
        _timeRemained.value = _setTime.value
        _setTime.value?.let {
            setCountdownTimer(it.times(SECOND_TO_MILLISECOND.toLong()))
        }
    }

    fun startTimer() {
        _setTime.value?.let {
            if (it == 0) {
                showSettingHint()
            } else if (_isPaused.value == false) {
                    showActionHint(CountdownStatus.RUNNING)
            } else {
                _timeRemained.value?.let {
                    setCountdownTimer(it.times(SECOND_TO_MILLISECOND.toLong()))
                }
                countDownTimer.start()
            }
        }
    }

    fun pauseTimer() {
        _setTime.value?.let {
            if (it == 0) {
                showSettingHint()
            } else if (_isCounting.value == true && it > 0) {
                showActionHint(CountdownStatus.PAUSE)
                _isPaused.value = true
                countDownTimer.cancel()
            } else {
                showActionHint(CountdownStatus.NON_START)
            }
        }
    }

    fun stopTimer() {
        _setTime.value?.let {
            if (it == 0) {
                showSettingHint()
            } else {
                _setTime.value = 0
                _timeRemained.value = 0
                countDownTimer.cancel()
                _isCounting.value = false
            }
        }
    }

    private fun setCountdownTimer(timeCountInMilliSeconds: Long) {
        countDownTimer =
            object : CountDownTimer(timeCountInMilliSeconds, SECOND_TO_MILLISECOND.toLong()) {
                override fun onTick(millisUntilFinished: Long) {
                    _setTime.value = _setTime.value?.minus(1)
                    _timeRemained.value =
                        (millisUntilFinished / SECOND_TO_MILLISECOND).toInt()
                    _isCounting.value = true
                    _isPaused.value = false
                }

                override fun onFinish() {
                    _setTime.value = 0
                    _isCounting.value = false
                }
            }
    }

    private fun showActionHint(countdownStatus: CountdownStatus) {
        when (countdownStatus.value) {
           "running" -> Toast.makeText(
                VoiceTubeApplication.INSTANCE.applicationContext,
                "已在計時中囉~",
                Toast.LENGTH_SHORT
            ).show()
            "pause" -> Toast.makeText(
                VoiceTubeApplication.INSTANCE.applicationContext,
                "計時器已暫停",
                Toast.LENGTH_SHORT
            ).show()
            else -> Toast.makeText(
                VoiceTubeApplication.INSTANCE.applicationContext,
                "計時器未開始",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    private fun showSettingHint() {
        Toast.makeText(
            VoiceTubeApplication.INSTANCE.applicationContext,
            "請先設定時間",
            Toast.LENGTH_SHORT
        ).show()
    }
}