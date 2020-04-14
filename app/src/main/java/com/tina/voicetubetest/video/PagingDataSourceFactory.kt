package com.tina.voicetubetest.video

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.tina.voicetubetest.data.Videos

class PagingDataSourceFactory : DataSource.Factory<String, Videos>() {

    val sourceLiveData = MutableLiveData<PagingDataSource>()

    override fun create(): DataSource<String, Videos> {
        val source = PagingDataSource()
        sourceLiveData.postValue(source)
        return source
    }
}