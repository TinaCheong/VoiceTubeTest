package com.tina.voicetubetest.video

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tina.voicetubetest.data.Videos
import com.tina.voicetubetest.databinding.ItemVideoBriefBinding

class VideoListAdapter : ListAdapter<Videos, VideoListAdapter.VideoViewHolder>(DiffCallback) {
    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder.from(parent)
    }

    class VideoViewHolder private constructor(val binding: ItemVideoBriefBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(videos: Videos) {
            binding.videos = videos
            binding.executePendingBindings()
        }

        companion object {
            fun from(
                parent: ViewGroup
            ): VideoViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemVideoBriefBinding.inflate(layoutInflater, parent, false)
                return VideoViewHolder(binding)
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Videos>() {
        override fun areItemsTheSame(oldItem: Videos, newItem: Videos): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Videos, newItem: Videos): Boolean {
            return oldItem.autoId == newItem.autoId
        }
    }
}