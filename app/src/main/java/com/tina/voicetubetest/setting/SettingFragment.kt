package com.tina.voicetubetest.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        binding.videoNotificationSwitch.isChecked = SettingManager.videonNotify
        binding.learnNotificationSwitch.isChecked = SettingManager.learningNotify

        return binding.root
    }

    override fun onPause() {
        super.onPause()
        saveSetting(binding.autoPlaySwitch, binding.autoPlaySwitch.isChecked)
        saveSetting(binding.subtitleSyncSwitch, binding.subtitleSyncSwitch.isChecked)
        saveSetting(binding.playingVideoSwitch, binding.playingVideoSwitch.isChecked)
        saveSetting(binding.videoNotificationSwitch, binding.videoNotificationSwitch.isChecked)
        saveSetting(binding.learnNotificationSwitch, binding.learnNotificationSwitch.isChecked)
    }


    private fun saveSetting(view: View, isOpened: Boolean){
        when(view){
            binding.autoPlaySwitch -> {
                when(isOpened){
                    true -> SettingManager.autoPlay = true
                    else -> SettingManager.autoPlay = false
                }
            }
            binding.subtitleSyncSwitch -> {
                when(isOpened){
                    true -> SettingManager.subtitle = true
                    else -> SettingManager.subtitle = false
                }
            }
            binding.playingVideoSwitch -> {
                when(isOpened){
                    true -> SettingManager.videoPlay = true
                    else -> SettingManager.videoPlay = false
                }
            }
            binding.videoNotificationSwitch -> {
                when(isOpened){
                    true -> SettingManager.videonNotify = true
                    else -> SettingManager.videonNotify = false
                }
            }
            binding.learnNotificationSwitch -> {
                when(isOpened){
                    true -> SettingManager.learningNotify = true
                    else -> SettingManager.learningNotify = false
                }
            }
        }
    }
}