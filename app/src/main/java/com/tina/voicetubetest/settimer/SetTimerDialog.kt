package com.tina.voicetubetest.settimer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.tina.voicetubetest.NavigationDirections
import com.tina.voicetubetest.databinding.DialogSetTimerBinding
import com.tina.voicetubetest.extension.getVmFactory

class SetTimerDialog : DialogFragment(){

    private val viewModel by viewModels<SetTimerViewModel> { getVmFactory(SetTimerDialogArgs.fromBundle(arguments!!).time) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DialogSetTimerBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        SetTimerDialog().dialog?.setCanceledOnTouchOutside(true)

        viewModel.navigateToTimer.observe(viewLifecycleOwner, Observer {
            if (it == null) {
                Toast.makeText(context, "請輸入秒數！", Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(NavigationDirections.actionGlobalTimerFragment(it))
                viewModel.onFinishNavigated()
            }
        })

        return binding.root
    }

}