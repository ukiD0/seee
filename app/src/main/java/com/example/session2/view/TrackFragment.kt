/**
 * Author Korovkina Valentina
 * Created at 10/04/24
 *
 * */
package com.example.session2.view

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.session2.R
import com.example.session2.common.Helper
import com.example.session2.databinding.FragmentTrackBinding
import com.example.session2.model.Orders
import com.example.session2.model.Profiles
import com.example.session2.viewmodel.OrderViewModel
import com.example.session2.viewmodel.StateViewModel
import kotlinx.coroutines.launch


class TrackFragment : Fragment() {
    private lateinit var binding: FragmentTrackBinding
    private lateinit var stateViewModel: StateViewModel
    private lateinit var orderViewModel: OrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentTrackBinding.inflate(inflater,container,false)
        stateViewModel = ViewModelProvider(requireActivity())[StateViewModel::class.java]
        orderViewModel = ViewModelProvider(requireActivity())[OrderViewModel::class.java]

        stateViewModel.setVisible(false)
        stateViewModel.setBottomVisible(true)

//

        var trackkk: Orders? = null
        lifecycleScope.launch {
            trackkk = orderViewModel.getOrder()
        }.invokeOnCompletion {
            if (trackkk != null){
                binding.trackNumder.text = "R" + trackkk?.id.toString()
            }
            binding.progbar.isVisible = false
            binding.maincontainer.isVisible = true
        }



        binding.viewpackageinfo.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_trackFragment_to_trackingSecondFragment)
        }


        return binding.root
    }

}