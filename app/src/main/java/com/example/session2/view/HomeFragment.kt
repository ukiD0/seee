/**
 * Author Korovkina Valentina
 * Created at 09/04/24
 *
 * */
package com.example.session2.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.session2.MainActivity
import com.example.session2.R
import com.example.session2.databinding.FragmentHomeBinding
import com.example.session2.viewmodel.ProfileViewModel
import com.example.session2.viewmodel.StateViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var stateViewModel: StateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        stateViewModel = ViewModelProvider(requireActivity())[StateViewModel::class.java]


        stateViewModel.setBottomVisible(true)
        stateViewModel.setVisible(false)
//        val menu = requireActivity().findViewById<BottomNavigationView>(R.id.bottomnav)
//        menu.isVisible = true
//        val cards = requireActivity().findViewById<CardView>(R.id.cwindowCard)
//        cards.isVisible = false

        return binding.root
    }

}