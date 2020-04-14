package com.tina.voicetubetest.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tina.voicetubetest.data.Videos

@Database(entities = [Videos::class], version = 1, exportSchema = false)
abstract class VideoDatabase : RoomDatabase(){

    abstract val videoDatabaseDao : VideoDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: VideoDatabase? = null

        fun getInstance(context: Context): VideoDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        VideoDatabase::class.java,
                        "task_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }


}