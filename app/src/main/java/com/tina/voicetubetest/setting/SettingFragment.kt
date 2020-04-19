package com.tina.voicetubetest.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.fragment.app.Fragment
import com.tina.voicetubetest.databinding.FragmentSettingBinding

class SettingFragment : Fragment(){

    lateinit var binding: FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSettingBinding.inflate(inflater, container, false)

        binding.autoPlaySwitch.isChecked = SettingManager.autoPlay
        binding.subtitleSyncSwitch.isChecked = SettingManager.subtitle
        binding.playingVideoSwitch.isChecked = SettingManager.videoPlay
        binding.videoNotificationSwitch.isChecked = SettingManager.videoNotify
        binding.learnNotificationSwitch.isChecked = SettingManager.learningNotify

        return binding.root
    }

    override fun onPause() {
        super.onPause()
        saveSetting(binding.autoPlaySwitch)
        saveSetting(binding.subtitleSyncSwitch)
        saveSetting(binding.playingVideoSwitch)
        saveSetting(binding.videoNotificationSwitch)
        saveSetting(binding.learnNotificationSwitch)
    }


    private fun saveSetting(switch: Switch){
        when(switch){
            binding.autoPlaySwitch -> SettingManager.autoPlay = switch.isChecked
            binding.subtitleSyncSwitch -> SettingManager.subtitle = switch.isChecked
            binding.playingVideoSwitch -> SettingManager.videoPlay = switch.isChecked
            binding.videoNotificationSwitch -> SettingManager.videoNotify = switch.isChecked
            binding.learnNotificationSwitch -> SettingManager.learningNotify = switch.isChecked
        }
    }
}