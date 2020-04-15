package com.tina.voicetubetest.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tina.voicetubetest.BuildConfig
import com.tina.voicetubetest.data.VideoResult
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

private const val HOST_NAME = "us-central1-lithe-window-713.cloudfunctions.net"
private const val BASE_URL = "https://$HOST_NAME/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val client = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply {
        level = when (BuildConfig.LOGGER_VISIABLE) {
            true -> HttpLoggingInterceptor.Level.BODY
            false -> HttpLoggingInterceptor.Level.NONE
        }
    })
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .client(client)
    .build()


interface VoiceTubeApiService {

    @FormUrlEncoded
    @POST("appQuiz?")
    fun getVideoList(@Field("key") key: String = "VoiceTube"): Deferred<VideoResult>
}


object VoiceTubeApi {
    val RETROFIT_SERVICE : VoiceTubeApiService by lazy { retrofit.create(VoiceTubeApiService::class.java) }
}