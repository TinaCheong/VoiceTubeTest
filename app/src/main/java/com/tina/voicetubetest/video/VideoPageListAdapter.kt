package com.tina.voicetubetest.video

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tina.voicetubetest.data.Videos
import com.tina.voicetubetest.databinding.ItemVideoBriefBinding

class VideoPageListAdapter :
    PagedListAdapter<Videos, VideoPageListAdapter.VideoViewHolder>(DiffCallback) {

    class VideoViewHolder(private var binding: ItemVideoBriefBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(videos: Videos) {
            binding.videos = videos
            binding.executePendingBindings()
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(ItemVideoBriefBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val videos = getItem(position)
        videos?.let { holder.bind(it) }
        }
    }