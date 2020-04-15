package com.tina.voicetubetest.video

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.tina.voicetubetest.R
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

//        val pagedListConfig = PagedList.Config.Builder().setEnablePlaceholders(true).setPageSize(3).setInitialLoadSizeHint(3).build()
//
//        val videoList = LivePagedListBuilder(viewModel.videos, pagedListConfig).build()

        viewModel.videos.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                (binding.recyclerviewList.adapter as VideoPageListAdapter).submitList(it)
            } else {
                viewModel.getVideos(true)
            }
        })


        viewModel.pagingDataVideos.observe(viewLifecycleOwner, Observer {
            (binding.recyclerviewList.adapter as VideoPageListAdapter).submitList(it)
        })

        binding.layoutSwipeRefreshList.setOnRefreshListener {
            viewModel.refresh()
        }

        viewModel.refreshStatus.observe(this, Observer {
            it?.let {
                binding.layoutSwipeRefreshList.isRefreshing = it
            }
        })

//        viewModel.videos.observe(this, Observer {
//            if (it.isNullOrEmpty()) {
//                binding.textError.setText(R.string.internet_refresh)
//            }
//
//        })

        return binding.root
    }
}