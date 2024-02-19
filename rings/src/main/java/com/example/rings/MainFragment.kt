package com.example.rings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rings.databinding.FragmentMainBinding


class MainFragment : Fragment() {
  private var _binding:FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater,container,false)
        val view = binding.root

        binding.findRing.setOnClickListener {
            this.findNavController().navigate(R.id.action_mainFragment_to_findRingFragment)
        }

        binding.addRing.setOnClickListener {
            this.findNavController().navigate(R.id.action_mainFragment_to_addRingFragment)
        }

        binding.help.setOnClickListener {
            this.findNavController().navigate(R.id.action_mainFragment_to_helpFragment)
        }
        return view
    }


}