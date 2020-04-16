package com.tina.voicetubetest.settimer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.tina.voicetubetest.databinding.DialogSetTimerBinding

class SetTimerDialog : DialogFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DialogSetTimerBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this

        SetTimerDialog().dialog?.setCanceledOnTouchOutside(true)

        return binding.root
    }

}