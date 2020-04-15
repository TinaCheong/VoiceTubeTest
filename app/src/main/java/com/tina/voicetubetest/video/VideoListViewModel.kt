package com.tina.voicetubetest.video

import android.provider.Settings.Global.getString
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.tina.voicetubetest.R
import com.tina.voicetubetest.VoiceTubeApplication
import com.tina.voicetubetest.data.Videos
import com.tina.voicetubetest.data.source.VoiceTubeRepository
import com.tina.voicetubetest.network.LoadApiStatus
import com.tina.voicetubetest.util.Util
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class VideoListViewModel(private val voiceTubeRepository: VoiceTubeRepository) : ViewModel() {

    private val sourceFactory = PagingDataSourceFactory()

    val videos : LiveData<PagedList<Videos>> = sourceFactory.toLiveData(3, null)

    val pagingDataVideos: LiveData<PagedList<Videos>> = sourceFactory.toLiveData(3, null)

    private val _status = MutableLiveData<LoadApiStatus>()

    val status: LiveData<LoadApiStatus>
        get() = _status

    private val _error = MutableLiveData<String>()

    val error: LiveData<String>
        get() = _error

    private val _refreshStatus = MutableLiveData<Boolean>()

    val refreshStatus: LiveData<Boolean>
        get() = _refreshStatus

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }



    fun getVideos(isInitial: Boolean = false) {

        coroutineScope.launch {

            if (!Util.isInternetConnected()) {
                Toast.makeText(
                    VoiceTubeApplication.INSTANCE.applicationContext,
                    Util.getString(R.string.internet_not_connected),
                    Toast.LENGTH_SHORT
                ).show()
                if (isInitial) _status.value = LoadApiStatus.ERROR

            } else {

                if (isInitial) _status.value = LoadApiStatus.LOADING

                when (val result = voiceTubeRepository.getVideoByNetwork()) {
                    is com.tina.voicetubetest.data.Result.Success -> {
                        _error.value = null
                        if (isInitial) _status.value = LoadApiStatus.DONE
                        result.data.videoList?.forEach {
                            voiceTubeRepository.insertVideos(it)
                        }
                    }
                    is com.tina.voicetubetest.data.Result.Fail -> {
                        _error.value = result.error
                        if (isInitial) _status.value = LoadApiStatus.ERROR
                    }
                    is com.tina.voicetubetest.data.Result.Error -> {
                        _error.value = result.exception.toString()
                        if (isInitial) _status.value = LoadApiStatus.ERROR
                    }
                    else -> {
                        _error.value = Util.getString(R.string.internet_error)
                        if (isInitial) _status.value = LoadApiStatus.ERROR
                    }
                }
            }
            _refreshStatus.value = false
        }
    }

    fun refresh() {
        if (status.value != LoadApiStatus.LOADING) {
            getVideos()
        }
    }

}