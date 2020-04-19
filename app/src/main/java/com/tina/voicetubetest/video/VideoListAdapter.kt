package com.tina.voicetubetest.video

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedList
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tina.voicetubetest.data.Videos
import com.tina.voicetubetest.databinding.ItemVideoBriefBinding

class VideoListAdapter :
    ListAdapter<Videos, VideoListAdapter.VideoViewHolder>(DiffCallback) {

    private var videoList: List<Videos>? = null

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
            return oldItem.title == newItem.title && oldItem.img == newItem.img
        }
    }

    override fun getItemCount(): Int {
        return videoList?.let { Int.MAX_VALUE } ?: 0
    }

    override fun submitList(list: List<Videos>?) {
        super.submitList(list)
        this.videoList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(ItemVideoBriefBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        videoList?.get(videoList?.let { position % it.size } ?: 0)?.let {
            holder.bind(it)
        }

        }
    }