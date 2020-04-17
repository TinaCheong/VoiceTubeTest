package com.tina.voicetubetest.setting

import android.content.Context
import com.tina.voicetubetest.VoiceTubeApplication

object SettingManager {

    private const val SETTING_DATA = "setting_data"
    private const val AUTO_PLAY = "auto_play"
    private const val SUBTITLE_SYNC = "subtitle_sync"
    private const val PLAY_VIDEO = "play_video"
    private const val VIDEO_NOTIFICATION = "video_notification"
    private const val LEARN_NOTIFICATION = "learn_notification"

    var autoPlay: Boolean
        get() {
            val sharedPreferences =
                VoiceTubeApplication.INSTANCE.getSharedPreferences(SETTING_DATA, Context.MODE_PRIVATE)
            return sharedPreferences.getBoolean(AUTO_PLAY, true)
        }
        set(value) {
            val setting = VoiceTubeApplication.INSTANCE.getSharedPreferences(SETTING_DATA, 0)
            setting.edit()
                .putBoolean(AUTO_PLAY, value)
                .apply()
        }

    var subtitle: Boolean
        get() {
            val sharedPreferences =
                VoiceTubeApplication.INSTANCE.getSharedPreferences(SETTING_DATA, Context.MODE_PRIVATE)
            return sharedPreferences.getBoolean(SUBTITLE_SYNC, true)
        }
        set(value) {
            val setting = VoiceTubeApplication.INSTANCE.getSharedPreferences(SETTING_DATA, 0)
            setting.edit()
                .putBoolean(SUBTITLE_SYNC, value)
                .apply()
        }

    var videoPlay: Boolean
        get() {
            val sharedPreferences =
                VoiceTubeApplication.INSTANCE.getSharedPreferences(SETTING_DATA, Context.MODE_PRIVATE)
            return sharedPreferences.getBoolean(PLAY_VIDEO, true)
        }
        set(value) {
            val setting = VoiceTubeApplication.INSTANCE.getSharedPreferences(SETTING_DATA, 0)
            setting.edit()
                .putBoolean(PLAY_VIDEO, value)
                .apply()
        }

    var videonNotify: Boolean
        get() {
            val sharedPreferences =
                VoiceTubeApplication.INSTANCE.getSharedPreferences(SETTING_DATA, Context.MODE_PRIVATE)
            return sharedPreferences.getBoolean(VIDEO_NOTIFICATION, true)
        }
        set(value) {
            val setting = VoiceTubeApplication.INSTANCE.getSharedPreferences(SETTING_DATA, 0)
            setting.edit()
                .putBoolean(VIDEO_NOTIFICATION, value)
                .apply()
        }

    var learningNotify: Boolean
        get() {
            val sharedPreferences =
                VoiceTubeApplication.INSTANCE.getSharedPreferences(SETTING_DATA, Context.MODE_PRIVATE)
            return sharedPreferences.getBoolean(LEARN_NOTIFICATION, true)
        }
        set(value) {
            val setting = VoiceTubeApplication.INSTANCE.getSharedPreferences(SETTING_DATA, 0)
            setting.edit()
                .putBoolean(LEARN_NOTIFICATION, value)
                .apply()
        }
}