package com.tina.voicetubetest.video

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.DataSource
import com.tina.voicetubetest.VoiceTubeApplication
import com.tina.voicetubetest.data.Videos

class PagingDataSourceFactory : DataSource.Factory<Int, Videos>() {

    override fun create(): DataSource<Int, Videos> {
        val source = PagingDataSource()
        return source
    }
}
