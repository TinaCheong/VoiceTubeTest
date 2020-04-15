package com.tina.voicetubetest.video

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.DataSource
import com.tina.voicetubetest.VoiceTubeApplication
import com.tina.voicetubetest.data.Videos

class PagingDataSourceFactory : DataSource.Factory<Int, Videos>() {

//    val sourceLiveData = MutableLiveData<PagingDataSource>()
//    val sourceDatabase = MutableLiveData<PagingLocalDataSources>()

    override fun create(): DataSource<Int, Videos> {
        val source = PagingDataSource()
        val localData = PagingLocalDataSources()

        if (VoiceTubeApplication.INSTANCE.voiceTubeRepository.getVideoByDatabase().value.isNullOrEmpty()) {
//            sourceLiveData.postValue(source)
            return source
        } else {
//            sourceDatabase.value = localData
            return localData
        }
    }
}
