package com.tina.voicetubetest.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tina.voicetubetest.databinding.FragmentSettingBinding

class SettingFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentSettingBinding.inflate(inflater, container, false)

        return binding.root
    }
}