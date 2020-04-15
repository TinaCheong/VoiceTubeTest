package com.tina.voicetubetest.video

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.tina.voicetubetest.R
import com.tina.voicetubetest.VoiceTubeApplication
import com.tina.voicetubetest.data.Videos
import com.tina.voicetubetest.network.LoadApiStatus
import com.tina.voicetubetest.util.Util.getString
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PagingDataSource : PageKeyedDataSource<Int, Videos>() {

    private val _statusInitialLoad = MutableLiveData<LoadApiStatus>()

    val statusInitialLoad: LiveData<LoadApiStatus>
        get() = _statusInitialLoad

    private val _errorInitialLoad = MutableLiveData<String>()

    val errorInitialLoad: LiveData<String>
        get() = _errorInitialLoad

    private val coroutineScope = CoroutineScope(Job() + Dispatchers.Main)


    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Videos>) {

        coroutineScope.launch {

            _statusInitialLoad.value = LoadApiStatus.LOADING

            val result = VoiceTubeApplication.INSTANCE.voiceTubeRepository.getVideoByNetwork()
            when (result) {
                is com.tina.voicetubetest.data.Result.Success -> {
                    _errorInitialLoad.value = null
                    _statusInitialLoad.value = LoadApiStatus.DONE
                   result.data.videoList?.let { callback.onResult(it, null, 3) }
                }
                is com.tina.voicetubetest.data.Result.Fail -> {
                    _errorInitialLoad.value = result.error
                    _statusInitialLoad.value = LoadApiStatus.ERROR
                }
                is com.tina.voicetubetest.data.Result.Error -> {
                    _errorInitialLoad.value = result.exception.toString()
                    _statusInitialLoad.value = LoadApiStatus.ERROR
                }
                else -> {
                    _errorInitialLoad.value = getString(R.string.internet_error)
                    _statusInitialLoad.value = LoadApiStatus.ERROR
                }
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Videos>) {

        coroutineScope.launch {
            val result = VoiceTubeApplication.INSTANCE.voiceTubeRepository.getVideoByNetwork()
            when (result) {
                is com.tina.voicetubetest.data.Result.Success -> {
                    result.data.videoList?.let { callback.onResult(it, 3) }
                }
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Videos>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}