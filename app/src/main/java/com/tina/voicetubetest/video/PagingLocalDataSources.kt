package com.tina.voicetubetest.video

import androidx.paging.PageKeyedDataSource
import androidx.paging.toLiveData
import com.tina.voicetubetest.VoiceTubeApplication
import com.tina.voicetubetest.data.Videos

class PagingLocalDataSources : PageKeyedDataSource<Int, Videos>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Videos>
    ) {
        val result = VoiceTubeApplication.INSTANCE.voiceTubeRepository.getVideoByDatabase()

        callback.onResult(result.value as MutableList<Videos>, null, 3)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Videos>) {
        val result = VoiceTubeApplication.INSTANCE.voiceTubeRepository.getVideoByDatabase()

        callback.onResult(result.value as MutableList<Videos>,  3)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Videos>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}