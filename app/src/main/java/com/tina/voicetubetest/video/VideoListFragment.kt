package com.tina.voicetubetest.video

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.tina.voicetubetest.data.Videos
import com.tina.voicetubetest.databinding.FragmentListBinding
import com.tina.voicetubetest.extension.getVmFactory

class VideoListFragment : Fragment(){

    private val viewModel by viewModels<VideoListViewModel> { getVmFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentListBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.recyclerviewList.adapter = VideoPageListAdapter()

        binding.recyclerviewList.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!recyclerView.canScrollVertically(1)){
                    viewModel.refresh()
                }
            }
        })

        viewModel.videosLocal.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                (binding.recyclerviewList.adapter as VideoPageListAdapter).submitList(it)
            } else {
                viewModel.getVideos(true)
                (binding.recyclerviewList.adapter as VideoPageListAdapter).submitList(viewModel.videos.value)
            }
        })

        binding.layoutSwipeRefreshList.setOnRefreshListener {
            viewModel.refresh()
        }

        viewModel.refreshStatus.observe(this, Observer {
            it?.let {
                binding.layoutSwipeRefreshList.isRefreshing = it
            }
        })

        return binding.root
    }
}