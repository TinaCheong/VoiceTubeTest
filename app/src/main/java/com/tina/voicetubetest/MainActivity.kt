package com.tina.voicetubetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.tina.voicetubetest.databinding.ActivityMainBinding
import com.tina.voicetubetest.extension.getVmFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.navigation_list -> {
                    findNavController(R.id.myNavHostFragment).navigate(NavigationDirections.actionGlobalVideoListFragment())
                    true
                }
                R.id.navigation_timer -> {
                    findNavController(R.id.myNavHostFragment).navigate(NavigationDirections.actionGlobalTimerFragment(0))
                    true
                }
                R.id.navigation_setting -> {
                    findNavController(R.id.myNavHostFragment).navigate(NavigationDirections.actionGlobalSettingFragment())
                    true
                }
                else -> false

                }

            }

        }
    }

