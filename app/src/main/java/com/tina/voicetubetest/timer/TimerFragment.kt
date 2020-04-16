package com.tina.voicetubetest.timer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.tina.voicetubetest.NavigationDirections
import com.tina.voicetubetest.R
import com.tina.voicetubetest.databinding.FragmentTimerBinding
import com.tina.voicetubetest.extension.getVmFactory

class TimerFragment : Fragment(){

    private val viewModel by viewModels<TimerViewModel> { getVmFactory(TimerFragmentArgs.fromBundle(arguments!!).time) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentTimerBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.setTimeButton.setOnClickListener {
            findNavController().navigate(NavigationDirections.actionGlobalSetTimerDialog(viewModel.time))
        }

        return binding.root
    }

}